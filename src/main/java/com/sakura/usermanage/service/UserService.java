package com.sakura.usermanage.service;


import com.alibaba.fastjson.JSON;
import com.sakura.usermanage.common.util.CommonConstant;
import com.sakura.usermanage.common.util.CommonsUtil;
import com.sakura.usermanage.common.util.JsonResult;
import com.sakura.usermanage.dao.generator.UserGeneratorMapper;
import com.sakura.usermanage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserGeneratorMapper userGeneratorMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public JsonResult<User> getUserList() {
        List<User> list = JSON.parseArray(redisTemplate.opsForHash().get(CommonConstant.REDIS_USER_KEY, "userList").toString(), User.class);
        if (CommonsUtil.isBlank(list)) {
            list = userGeneratorMapper.selectAll();
        }
        redisTemplate.opsForHash().put(CommonConstant.REDIS_USER_KEY, "userList", JSON.toJSON(list));
        return JsonResult.success(list);
    }
}
