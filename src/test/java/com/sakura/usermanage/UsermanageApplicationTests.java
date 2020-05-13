package com.sakura.usermanage;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.collect.Maps;
import com.sakura.usermanage.common.util.JwtUtil;
import com.sakura.usermanage.common.util.MD5Util;
import com.sakura.usermanage.dao.generator.UserGeneratorMapper;
import com.sakura.usermanage.dao.mapper.UserMapper;
import com.sakura.usermanage.entity.Role;
import com.sakura.usermanage.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

import static tk.mybatis.mapper.entity.Example.Criteria;


@SpringBootTest
class UsermanageApplicationTests {

	@Autowired
	private UserMapper userMapper;


	public static void main(String[] args) {
//		String passwrod = MD5Util.getMD5("123456");
//		System.out.println(MD5Util.getMD5("123456"));
//		System.out.println(passwrod);
		JwtUtil.JwtUser jwtUser = new JwtUtil.JwtUser();
		jwtUser.setId("1193");
		jwtUser.setName("admin");
		String token = JwtUtil.createJWT(jwtUser);
		System.out.println(token);
		Claims claims = JwtUtil.parseJWT(token);
		System.out.println(JSON.toJSONString(claims));
	}

	@Test
	void t3() {
		List<User> list = userMapper.select(Maps.newHashMap());
		System.out.println(JSON.toJSONString(list));
	}

	@Autowired
	private UserGeneratorMapper userGeneratorMapper;
	@Test
	void t1() {
//		Example example = new Example(User.class);
//		example.createCriteria().andEqualTo("id", 1);
//		List<User> list = userGeneratorMapper.selectByExample(example);
        List<User> list = userGeneratorMapper.select(User.builder().id(1).build());
		System.out.println(JSON.toJSONString(list));
	}

	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Test
    public void t2() {
        List<Role> list = sqlSessionTemplate.selectList("RoleMapper.select");
        System.out.println(JSON.toJSONString(list));
    }
}
