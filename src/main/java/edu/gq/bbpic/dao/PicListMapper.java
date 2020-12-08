package edu.gq.bbpic.dao;

import edu.gq.bbpic.pojo.PicList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PicListMapper {
    int deleteByPrimaryKey(Integer picListId);

    int insert(PicList record);

    PicList selectByPrimaryKey(Integer picListId);

    PicList selectByNameAndUserId(PicList picList);

    List selectHot(int left, int right, int enable);

    List selectHotByCategory(int left, int right, int enable, int categoryId);

    List selectNew(int left, int right, int enable);

    List selectNewByCategory(int left, int right, int enable, int categoryId);

    int updateByPrimaryKeySelective(PicList record);
}