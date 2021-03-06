package edu.gq.bbpic.service.impl;

import edu.gq.bbpic.common.Const;
import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.dao.CollectMapper;
import edu.gq.bbpic.dao.PicListMapper;
import edu.gq.bbpic.dao.PictureMapper;
import edu.gq.bbpic.dao.PraiseMapper;
import edu.gq.bbpic.pojo.Collect;
import edu.gq.bbpic.pojo.PicList;
import edu.gq.bbpic.pojo.Picture;
import edu.gq.bbpic.pojo.Praise;
import edu.gq.bbpic.service.StaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.Map;

@Service("staService")
public class StaServiceImpl implements StaService {
    @Autowired
    private PraiseMapper praiseMapper;
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private PicListMapper picListMapper;
    @Autowired
    private PictureMapper pictureMapper;

    @Override
    @Transactional
    public ServerResponse togglePraise(Praise praise) {
        try {
            Praise praiseGet = praiseMapper.select(praise);
            Picture picture = pictureMapper.selectByPrimaryKey(praise.getPictureId());
            PicList picList = picListMapper.selectByPrimaryKey(picture.getPicListId());

            if(praiseGet == null){
                praise.setIsCancel(0);
                praiseMapper.insert(praise);
                picture.setHeat(picture.getHeat() + 1);
                picture.setPraiseNum(picture.getPraiseNum() + 1);
            } else {
                if(praiseGet.getIsCancel() == 0){
                    praise.setIsCancel(1);
                    picture.setHeat(picture.getHeat() - 1);
                    picture.setPraiseNum(picture.getPraiseNum() - 1);
                }
                if(praiseGet.getIsCancel() == 1){
                    praise.setIsCancel(0);
                    picture.setHeat(picture.getHeat() + 1);
                    picture.setPraiseNum(picture.getPraiseNum() + 1);
                }
                praiseMapper.update(praise);
            }
            if(picList != null){
                if(praise.getIsCancel() == 0){
                    picList.setHeat(picList.getHeat() + 1);
                }
                if(praise.getIsCancel() == 1){
                    picList.setHeat(picList.getHeat() - 1);
                }
                picListMapper.updateByPrimaryKeySelective(picList);
            }

            pictureMapper.updateByPrimaryKeySelective(picture);

            return new ServerResponse(Const.ResCode.SUCCEES, praise);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }

    @Override
    @Transactional
    public ServerResponse toggleCollect(Collect collect) {
        try {
            Collect collectGet = collectMapper.select(collect);

            if(collectGet == null){
                collect.setIsCancel(0);
                collectMapper.insert(collect);
            } else {
                if(collectGet.getIsCancel() == 0){
                    collect.setIsCancel(1);
                }
                if(collectGet.getIsCancel() == 1){
                    collect.setIsCancel(0);
                }
                collectMapper.update(collect);
            }

            Picture picture = null;
            PicList picList = null;

            if(collect.getObjectType() == 1){
                picture = pictureMapper.selectByPrimaryKey(collect.getOjectId());
                if(collect.getIsCancel() == 0){
                    picture.setCollectNum(picture.getCollectNum() + 1);
                    picture.setHeat(picture.getHeat() + 5);
                }
                if(collect.getIsCancel() == 1){
                    picture.setCollectNum(picture.getCollectNum() - 1);
                    picture.setHeat(picture.getHeat() - 5);
                }
                pictureMapper.updateByPrimaryKeySelective(picture);
            }
            if(collect.getObjectType() == 2){
                picList = picListMapper.selectByPrimaryKey(collect.getOjectId());
                if(collect.getIsCancel() == 0){
                    picList.setCollectNum(picture.getCollectNum() + 1);
                    picList.setHeat(picture.getHeat() + 5);
                }
                if(collect.getIsCancel() == 1){
                    picList.setCollectNum(picture.getCollectNum() - 1);
                    picList.setHeat(picture.getHeat() - 5);
                }
                picListMapper.updateByPrimaryKeySelective(picList);
            }

            return new ServerResponse(Const.ResCode.SUCCEES, collect);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }

    @Override
    public ServerResponse getPraiseAndCollectInfo(int userId, int pictureId) {
        try{
            Praise praise = new Praise();
            praise.setPictureId(pictureId);
            praise.setUserId(userId);
            Praise pGet = praiseMapper.select(praise);

            Collect collect = new Collect();
            collect.setOjectId(pictureId);
            collect.setObjectType(1);
            collect.setUserId(userId);
            Collect cGet = collectMapper.select(collect);

            Picture picture = pictureMapper.selectByPrimaryKey(pictureId);

            Map map = new HashMap();
            map.put("praiseInfo", pGet);
            map.put("collectInfo", cGet);
            map.put("pictureInfo", picture);

            return new ServerResponse(Const.ResCode.SUCCEES, map);
        } catch (Exception e) {
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }
}
