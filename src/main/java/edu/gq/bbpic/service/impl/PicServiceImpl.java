package edu.gq.bbpic.service.impl;

import edu.gq.bbpic.common.Const;
import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.dao.PicListMapper;
import edu.gq.bbpic.dao.PictureMapper;
import edu.gq.bbpic.pojo.PicList;
import edu.gq.bbpic.pojo.Picture;
import edu.gq.bbpic.service.PicService;
import edu.gq.bbpic.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service("picService")
public class PicServiceImpl implements PicService {
    @Autowired
    private PicListMapper picListMapper;
    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public ServerResponse addPicList(PicList picList) {
        try{
            PicList isExit = null;
            isExit = picListMapper.selectByNameAndUserId(picList);
            if(isExit != null){
                return new ServerResponse(Const.ResCode.FAIL, "图集已存在");
            }
            picList.setCollectNum(0);
            picList.setEnable(0);
            picList.setHeat(0);

            picListMapper.insert(picList);

            return new ServerResponse(Const.ResCode.SUCCEES, "添加图集成功");
        } catch (Exception e) {
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }

    @Override
    @Transactional
    public ServerResponse uploadSinglePic(MultipartFile file, Map map) {
        try{
            Picture picture = new Picture();
            picture.setPicListId(0);
            picture.setCategoryId((int) map.get("categoryId"));
            picture.setUserId((int) map.get("userId"));
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

            return new ServerResponse(Const.ResCode.SUCCEES, "上传成功");
        } catch (Exception e) {
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }

    @Override
    @Transactional
    public ServerResponse uploadPicToList(MultipartFile file, Map map) {
        try{
            PicList isExit = null;
            isExit = picListMapper.selectByPrimaryKey((int) map.get("picListId"));
            if(isExit == null){
                return new ServerResponse(Const.ResCode.FAIL, "图集不存在");
            }

            Picture picture = new Picture();
            picture.setPicListId((int) map.get("picListId"));
            picture.setCategoryId((int) map.get("categoryId"));
            picture.setUserId((int) map.get("userId"));
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

            return new ServerResponse(Const.ResCode.SUCCEES, "上传成功");
        } catch (Exception e) {
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }

    @Override
    public ServerResponse getPicList(int currentPage, int pageSize, String type, int enable) {
        try{
            List picList = null;
            if("new".equals(type)){
                picList = pictureMapper.selectNew(currentPage, pageSize, enable);
            }
            if("hot".equals(type)){
                picList = pictureMapper.selectHot(currentPage, pageSize, enable);
            }
            return new ServerResponse(Const.ResCode.SUCCEES, "ok", picList);
        } catch (Exception e) {
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }

    @Override
    public ServerResponse getPicSetList(int currentPage, int pageSize, String type, int enable) {
        try{
            List picSetList = null;
            if("new".equals(type)){
                picSetList = picListMapper.selectNew(currentPage, pageSize, enable);
            }
            if("hot".equals(type)){
                picSetList = picListMapper.selectHot(currentPage, pageSize, enable);
            }
            return new ServerResponse(Const.ResCode.SUCCEES, "ok", picSetList);
        } catch (Exception e) {
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }
}
