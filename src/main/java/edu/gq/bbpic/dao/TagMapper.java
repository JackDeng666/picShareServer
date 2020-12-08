package edu.gq.bbpic.dao;

import edu.gq.bbpic.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper {
    int insert(Tag record);
}