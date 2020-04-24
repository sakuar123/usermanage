package com.sakura.usermanage.config.listen;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.sakura.usermanage.dao.UserMapper;
import com.sakura.usermanage.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;


@Slf4j
@Component
public class SpringBootStartListener implements ApplicationRunner {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Jedis jedis = new Jedis("localhost");
//        List<User> list = Lists.newArrayList();
//        jedis.set("userList", JSON.toJSON(list).toString());
//        log.info("SpringBoot启动成功:" + jedis.get("userList"));
        log.info("SpringBoot启动成功。");
    }
}