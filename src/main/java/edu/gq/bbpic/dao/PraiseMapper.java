package edu.gq.bbpic.dao;

import edu.gq.bbpic.pojo.Praise;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PraiseMapper {
    Praise select(Praise praise);

    int insert(Praise record);

    int update(Praise praise);
}