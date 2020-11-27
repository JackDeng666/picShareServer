package edu.gq.bbpic.dao;

import edu.gq.bbpic.pojo.Praise;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PraiseMapper {
    int insert(Praise record);

    int insertSelective(Praise record);
}