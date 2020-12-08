package edu.gq.bbpic.dao;

import edu.gq.bbpic.pojo.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PictureMapper {
    int deleteByPrimaryKey(Integer pictureId);

    int insert(Picture record);

    Picture selectByPrimaryKey(Integer pictureId);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);

    List selectNew(int left, int right, int enable);

    List selectHotByCategory(int left, int right, int enable, int categoryId);

    List selectHot(int left, int right, int enable);

    List selectNewByCategory(int left, int right, int enable, int categoryId);

    List selectByPicListId(Integer picListId);
}