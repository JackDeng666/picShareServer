package edu.gq.bbpic.service;

import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.pojo.User;

public interface UserService {
    ServerResponse login(String account, String password);

    ServerResponse adminLogin(String account, String password);

    ServerResponse<String> register(User user);

    ServerResponse checkUserToken(String token);

    ServerResponse checkAdminToken(String token);

    ServerResponse checkSuperAdminToken(String token);

    ServerResponse getUserList(int currentPage, int pageSize);

    ServerResponse updateUser(User user);

    ServerResponse updateEnable(User user);

//    ServerResponse searchUser(String searchKeyWord);
}
