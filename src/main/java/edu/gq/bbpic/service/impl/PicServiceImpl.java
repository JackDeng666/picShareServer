package edu.gq.bbpic.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.gq.bbpic.common.Const;
import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.dao.PicListMapper;
import edu.gq.bbpic.dao.PictureMapper;
import edu.gq.bbpic.dao.TagMapper;
import edu.gq.bbpic.dao.UserMapper;
import edu.gq.bbpic.pojo.PicList;
import edu.gq.bbpic.pojo.Picture;
import edu.gq.bbpic.pojo.Tag;
import edu.gq.bbpic.service.PicService;
import edu.gq.bbpic.util.ImageUtil;
import edu.gq.bbpic.vo.PicListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service("picService")
public class PicServiceImpl implements PicService {
    @Autowired
    private PicListMapper picListMapper;
    @Autowired
    private PictureMapper pictureMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public ServerResponse addPicList(Map map) {
        try{
            PicList picList = new PicList();
            picList.setPicListName((String) map.get("picListName"));
            picList.setUserId((Integer) map.get("userId"));
            picList.setIntro((String) map.get("intro"));

            PicList isExit = null;
            isExit = picListMapper.selectByNameAndUserId(picList);
            if(isExit != null){
                return new ServerResponse(Const.ResCode.FAIL, "图集已存在");
            }
            picList.setCollectNum(0);
            picList.setEnable(0);
            picList.setHeat(0);

            picListMapper.insert(picList);

            ArrayList<Integer> categorys = (ArrayList) map.get("categorys");

            for (int id: categorys) {
                Tag tag = new Tag();
                tag.setCategoryId(id);
                tag.setObjectType(1);
                tag.setObjectId(picList.getPicListId());
                tagMapper.insert(tag);
            }

            Map res = new HashMap();
            res.put("picList", picList);
            res.put("categorys", categorys);
            return new ServerResponse(Const.ResCode.SUCCEES, "添加图集成功", res);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }

    @Override
    @Transactional
    public ServerResponse uploadSinglePic(MultipartFile file, Map map) {
        try{
            int userId = Integer.valueOf(((String [])map.get("userId"))[0]);
            JSONArray categorys = JSON.parseArray(((String [])map.get("categorys"))[0]);

            Picture picture = new Picture();
            picture.setPicListId(0);
            picture.setUserId(userId);
            picture.setPraiseNum(0);
            picture.setCollectNum(0);
            picture.setEnable(0);
            picture.setHeat(0);

            ServerResponse res = ImageUtil.saveImage(file);
            if(res.getStatus() != Const.ResCode.SUCCEES){
                return new ServerResponse(Const.ResCode.FAIL, "上传失败");
            }

            Map urlMap = (Map) res.getData();
            picture.setOdUrl((String) urlMap.get("oUrl"));
            picture.setThumbnailUrl((String) urlMap.get("tUrl"));

            pictureMapper.insert(picture);

            for (Object id: categorys) {
                Tag tag = new Tag();
                tag.setCategoryId((Integer) id);
                tag.setObjectType(0);
                tag.setObjectId(picture.getPictureId());
                tagMapper.insert(tag);
            }

            return new ServerResponse(Const.ResCode.SUCCEES, "上传成功");
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }

    @Override
    @Transactional
    public ServerResponse uploadPicToList(MultipartFile file, Map map) {
        try{
            JSONObject picList = JSON.parseObject(((String [])map.get("picList"))[0]);
            JSONArray categorys = JSON.parseArray(((String [])map.get("categorys"))[0]);

            PicList isExit = null;
            isExit = picListMapper.selectByPrimaryKey((Integer) picList.get("picListId"));
            if(isExit == null){
                return new ServerResponse(Const.ResCode.FAIL, "图集不存在");
            }

            Picture picture = new Picture();
            picture.setPicListId((Integer) picList.get("picListId"));
            picture.setUserId((Integer) picList.get("userId"));
            picture.setPraiseNum(0);
            picture.setCollectNum(0);
            picture.setEnable(0);
            picture.setHeat(0);

            ServerResponse res = ImageUtil.saveImage(file);
            if(res.getStatus() != Const.ResCode.SUCCEES){
                return new ServerResponse(Const.ResCode.FAIL, "上传失败");
            }

            Map urlMap = (Map) res.getData();
            picture.setOdUrl((String) urlMap.get("oUrl"));
            picture.setThumbnailUrl((String) urlMap.get("tUrl"));

            pictureMapper.insert(picture);

            for (Object id: categorys) {
                Tag tag = new Tag();
                tag.setCategoryId((Integer) id);
                tag.setObjectType(0);
                tag.setObjectId(picture.getPictureId());
                tagMapper.insert(tag);
            }

            return new ServerResponse(Const.ResCode.SUCCEES, "上传成功");
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }

    @Override
    public ServerResponse getPicList(int currentPage, int pageSize, String type, int enable, int categoryId) {
        try{
            List picList = null;
            if("new".equals(type)){
                // 不通过分类
                if(categoryId == 0){
                    picList = pictureMapper.selectNew((currentPage-1) * pageSize, pageSize, enable);
                } else {
                    picList = pictureMapper.selectNewByCategory((currentPage-1) * pageSize, pageSize, enable, categoryId);
                }
            }
            if("hot".equals(type)){
                // 不通过分类
                if(categoryId == 0){
                    picList = pictureMapper.selectHot((currentPage-1) * pageSize, pageSize, enable);
                } else {
                    picList = pictureMapper.selectHotByCategory((currentPage-1) * pageSize, pageSize, enable, categoryId);
                }
            }
            return new ServerResponse(Const.ResCode.SUCCEES, "ok", picList);
        } catch (Exception e) {
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }

    @Override
    public ServerResponse getPicSetList(int currentPage, int pageSize, String type, int enable, int categoryId) {
        try{
            List<PicListVo> picSetList = null;
            if("new".equals(type)){
                if(categoryId == 0){
                    picSetList = contact(picListMapper.selectNew((currentPage-1) * pageSize, pageSize, enable));
                } else {
                    picSetList = contact(picListMapper.selectNewByCategory((currentPage-1) * pageSize, pageSize, enable, categoryId));
                }
            }
            if("hot".equals(type)){
                if(categoryId == 0){
                    picSetList = contact(picListMapper.selectHot((currentPage-1) * pageSize, pageSize, enable));
                } else {
                    picSetList = contact(picListMapper.selectHotByCategory((currentPage-1) * pageSize, pageSize, enable, categoryId));
                }
            }
            return new ServerResponse(Const.ResCode.SUCCEES, "ok", picSetList);
        } catch (Exception e) {
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }

    @Override
    public ServerResponse updatePicture(Picture picture) {
        try{
            pictureMapper.updateByPrimaryKeySelective(picture);
            return new ServerResponse(Const.ResCode.SUCCEES, "修改成功");
        } catch (Exception e) {
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }

    @Override
    public ServerResponse updatePicList(PicList picList) {
        try{
            picListMapper.updateByPrimaryKeySelective(picList);
            return new ServerResponse(Const.ResCode.SUCCEES, "修改成功");
        } catch (Exception e) {
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }

    public List<PicListVo> contact(List<PicList> picLists){
        List<PicListVo> picSetList = new LinkedList<>();

        for (PicList picList: picLists) {
            PicListVo picListVo = new PicListVo();

            picListVo.setCollectNum(picList.getCollectNum());
            picListVo.setCreationTime(picList.getCreationTime());
            picListVo.setHeat(picList.getHeat());
            picListVo.setIntro(picList.getIntro());
            picListVo.setEnable(picList.getEnable());
            picListVo.setPicListId(picList.getPicListId());
            picListVo.setPicListName(picList.getPicListName());

            picListVo.setPictures(pictureMapper.selectByPicListId(picList.getPicListId()));
            picListVo.setTags(tagMapper.select(picList.getPicListId(), 1));
            picListVo.setUser(userMapper.selectByPrimaryKey(picList.getUserId()));

            picSetList.add(picListVo);
        }
        return picSetList;
    }
}
