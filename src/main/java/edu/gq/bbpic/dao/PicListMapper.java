package edu.gq.bbpic.dao;

import edu.gq.bbpic.pojo.PicList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PicListMapper {
    int deleteByPrimaryKey(Integer picListId);

    int insert(PicList record);

    int insertSelective(PicList record);

    PicList selectByPrimaryKey(Integer picListId);

    int updateByPrimaryKeySelective(PicList record);

    int updateByPrimaryKey(PicList record);
}