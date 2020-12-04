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

    List selectHot(int currentPage, int pageSize, int enable);

    List selectNew(int currentPage, int pageSize, int enable);

    int updateByPrimaryKeySelective(PicList record);
}