package edu.gq.bbpic.dao;

import edu.gq.bbpic.pojo.Collect;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollectMapper {
    int insert(Collect record);

    int insertSelective(Collect record);
}