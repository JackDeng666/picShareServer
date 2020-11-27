package edu.gq.bbpic.service.impl;

import com.alibaba.fastjson.JSON;
import edu.gq.bbpic.common.Const;
import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.dao.UserMapper;
import edu.gq.bbpic.pojo.User;
import edu.gq.bbpic.service.UserService;
import edu.gq.bbpic.util.JwtHelper;
import edu.gq.bbpic.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    // 普通用户登陆
    @Override
    public ServerResponse<User> login(String account, String password) {
        // 密码登陆MD5
        String mdPsw = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.checkLogin(account, mdPsw);
        if (user == null) {
            return new ServerResponse(Const.ResCode.FAIL, "登陆失败，用户不存在或密码错误");
        }
        user.setPassword(null);
        // 创建token
        Map<String, String> claims = new HashMap<>();
        claims.put("account", user.getAccount());
        claims.put("role", "2");
        claims.put("id", user.getUserId().toString());
        // 7天过期
        String token = JwtHelper.genToken(claims, new Date(new Date().getTime() + 7 * 24 * 3600 * 1000));
        // 返回结果
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("userInfo", user);
        resMap.put("token", token);
        return new ServerResponse(Const.ResCode.SUCCEES, "登陆成功", resMap);
    }

    // 超级管理员登陆
    @Override
    public ServerResponse<User> adminLogin(String account, String password) {
        // 密码登陆MD5
        String mdPsw = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.checkLogin(account, mdPsw);
        if (user == null) {
            return new ServerResponse(Const.ResCode.FAIL, "登陆失败，用户不存在或密码错误");
        }
        if (user.getRole() != 0) {
            return new ServerResponse(Const.ResCode.FAIL, "登陆失败，非超级管理员");
        }
        user.setPassword(null);
        // 创建token
        Map<String, String> claims = new HashMap<>();
        claims.put("account", user.getAccount());
        claims.put("role", user.getRole().toString());
        claims.put("id", user.getUserId().toString());
        // 1天过期
        String token = JwtHelper.genToken(claims, new Date(new Date().getTime() + 1 * 24 * 3600 * 1000));
        // 返回结果
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("userInfo", user);
        resMap.put("token", token);
        return new ServerResponse(Const.ResCode.SUCCEES, "登陆成功", resMap);
    }

    @Override
    public ServerResponse register(User user) {
        int count = userMapper.selectByAccount(user.getAccount());
        if (count != 0) {
            return new ServerResponse(Const.ResCode.FAIL, "注册失败，账号存在");
        }
        // 防止被刷权限
        user.setRole(2);
        // 加密密码
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
        return new ServerResponse(Const.ResCode.SUCCEES, "注册成功");
    }

    // 检查用户token
    @Override
    public ServerResponse checkUserToken(String token) {
        Map<String, String> map = null;
        try {
            map = JwtHelper.verifyToken(token);
        } catch (Exception e) {
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        } finally {
            if (map == null) {
                return new ServerResponse(Const.ResCode.FAIL, "token无效");
            } else {
                return new ServerResponse(Const.ResCode.SUCCEES, "token有效", map);
            }
        }
    }

    // 检查管理员token
    @Override
    public ServerResponse checkAdminToken(String token) {
        Map<String, String> map = null;
        try {
            map = JwtHelper.verifyToken(token);
        } catch (Exception e) {
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        } finally {
            if (map == null) {
                return new ServerResponse(Const.ResCode.FAIL, "token无效");
            } else {
                String role = map.get("role");
                if (role.equals("1")) {
                    return new ServerResponse(Const.ResCode.SUCCEES, "是管理员", map);
                }
                return new ServerResponse(Const.ResCode.NEED_ROLE, "非管理员");
            }
        }
    }

    // 检查超级管理员token
    @Override
    public ServerResponse checkSuperAdminToken(String token) {
        Map<String, String> map = null;
        try {
            map = JwtHelper.verifyToken(token);
        } catch (Exception e) {
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        } finally {
            if (map == null) {
                return new ServerResponse(Const.ResCode.FAIL, "token无效");
            } else {
                String role = map.get("role");
                if (role.equals("0")) {
                    return new ServerResponse(Const.ResCode.SUCCEES, "是超级管理员", map);
                }
                return new ServerResponse(Const.ResCode.NEED_ROLE, "非超级管理员");
            }
        }
    }

    /*@Override
    public ServerResponse getUserList(int currentPage, int pageSize) {
        try {
            int total = userMapper.selectCount();
            // 分页查询
            int skip = (currentPage - 1) * pageSize;
            List list = userMapper.selectByPage(skip, pageSize);
            Map map = new HashMap();
            map.put("userList", list);
            map.put("total", total);
            return new ServerResponse(Const.ResCode.SUCCEES, "获取用户列表成功", map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }*/

    /*@Override
    public ServerResponse searchUser(String searchKeyWord) {
        try {
            List list = userMapper.search(searchKeyWord);
            return new ServerResponse(Const.ResCode.SUCCEES, "搜索用户成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }*/
}
