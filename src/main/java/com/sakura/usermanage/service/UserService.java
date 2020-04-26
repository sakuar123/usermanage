package com.sakura.usermanage.service;


import com.alibaba.fastjson.JSONObject;

import com.sakura.usermanage.common.util.CommonsUtil;
import com.sakura.usermanage.common.util.JsonResult;
import com.sakura.usermanage.dao.generator.UserGeneratorMapper;
import com.sakura.usermanage.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserGeneratorMapper userGeneratorMapper;

    public JsonResult<User> getUserList() {
        Jedis jedis = new Jedis("localhost");
        String users = jedis.get("userList");

        List<User> list = JSONObject.parseArray(users, User.class);
        if (CommonsUtil.isBlank(list)) {
            list = userGeneratorMapper.selectAll();
        }
        return JsonResult.success(list);
    }
}
