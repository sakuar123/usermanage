package com.sakura.usermanage.config.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sakura.usermanage.common.util.CommonConstant;
import com.sakura.usermanage.common.util.JwtUtil;
import com.sakura.usermanage.config.security.Permission;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 李七夜 on 2020/5/8 19:50
 */
@Slf4j
public class TicketInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Permission permission = handlerMethod.getMethodAnnotation(Permission.class);
			if (permission.noLogin()) {
				return true;
			}
			String token = request.getHeader("token");
			try {
				Claims claims = JwtUtil.parseJWT(token);
				Assert.isNull(claims, "非法生成的token,请重新登录");
				JSONObject jsonObject = JSONObject.parseObject(JSON.toJSON(claims).toString());
				Assert.isNull(redisTemplate.opsForHash().get(CommonConstant.REDIS_USER_KEY, jsonObject.getString("password")), "会话已失效或已过期,请重新登录");
				String userId = redisTemplate.opsForHash().get(CommonConstant.REDIS_USER_KEY, jsonObject.getString("password")).toString();
				request.setAttribute("userId", userId);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}
}
