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

    List selectNew(int currentPage, int pageSize, int enable);

    List selectHot(int currentPage, int pageSize, int enable);
}