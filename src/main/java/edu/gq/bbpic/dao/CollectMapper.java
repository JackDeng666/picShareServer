package edu.gq.bbpic.dao;

import edu.gq.bbpic.pojo.Collect;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollectMapper {
    Collect select(Collect collect);

    int insert(Collect record);

    int update(Collect collect);
}