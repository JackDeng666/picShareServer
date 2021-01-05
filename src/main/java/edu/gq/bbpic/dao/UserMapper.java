package edu.gq.bbpic.dao;

import edu.gq.bbpic.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKey(User record);

    int updateEnable(User record);

    User checkLogin(String account, String password);

    int selectByAccount(String account);

    int selectCount();

    List selectByPage(int left, int right);

    int updateByPrimaryKeySelective(User user);

//    List search(String searchKeyWord);
}