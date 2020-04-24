package com.sakura.usermanage.service;


import com.alibaba.fastjson.JSONObject;

import com.sakura.usermanage.common.util.JsonResult;
import com.sakura.usermanage.entity.User;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class UserService {

    public JsonResult<User> getUserList() {
        Jedis jedis = new Jedis("localhost");
        String users = jedis.get("userList");

        List<User> list = JSONObject.parseArray(users, User.class);
        return JsonResult.success(list);
    }
}
