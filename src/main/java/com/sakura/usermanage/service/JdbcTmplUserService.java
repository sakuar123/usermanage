package com.sakura.usermanage.service;

import com.sakura.usermanage.entity.User;

import java.util.List;

public interface JdbcTmplUserService {

    User getUser(Integer userId);

    List<User> findUserList(String userName, Integer sex);

    Integer inserUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(Integer userId);
}
