package com.sakura.usermanage;

import com.alibaba.fastjson.JSON;
import com.sakura.usermanage.common.util.JsonResult;
import com.sakura.usermanage.dao.UserMapper;
import com.sakura.usermanage.entity.User;
import com.sakura.usermanage.service.JdbcTmplUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@SpringBootTest
class UsermanageApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    void t1() {
        System.out.println(JsonResult.success(userMapper.select(null)));
    }

    @Autowired
    private JdbcTmplUserService jdbcTmplUserService;

    @Test
    void t2() {
        User user = jdbcTmplUserService.getUser(1);
        List<User> userList = jdbcTmplUserService.findUserList("a", 1);
        userList.forEach(user1 -> {
            user1.setCreatedBy(1L);
            user1.setCreationDate(new Date());
        });
        System.out.println(JSON.toJSON(user));
        System.out.println(JSON.toJSON(userList));
    }
}
