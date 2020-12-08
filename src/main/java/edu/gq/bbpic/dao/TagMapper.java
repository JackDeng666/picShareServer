package edu.gq.bbpic.dao;

import edu.gq.bbpic.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {
    List select(Integer objectId, Integer objectType);

    int insert(Tag record);
}