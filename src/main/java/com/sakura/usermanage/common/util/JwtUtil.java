package com.sakura.usermanage.common.util;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.sakura.usermanage.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 李七夜 on 2020/5/8 17:47
 */
public class JwtUtil {

	/*失效时间,默认为1个小时*/
	private final static Date EXPIRATION_TIME = DateUtils.addHours(new Date(), +1);

	/**
	 * 生成jwt
	 * @param jwtUser
	 * @return
	 */
	public static String createJWT(JwtUser jwtUser) {
		return createJWT(EXPIRATION_TIME, jwtUser);
	}

	/**
	 * 用户登录成功后生成Jwt
	 * 使用Hs256算法  私匙使用用户密码
	 *
	 * @param expirationDate jwt过期时间
	 * @param user  登录成功的user对象
	 * @return
	 */
	public static String createJWT(Date expirationDate, JwtUser user) {
		//指定签名的时候使用的签名算法
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		//创建payload的私有声明
		Map<String, Object> claims = Maps.newHashMap();
		claims.put("id", user.getId());
		claims.put("user", JSON.toJSON(user));
		//生成签名的时候使用的秘钥secret
		String key = user.getPassword();
		//生成签发人
		String subject = user.getName();
		//下面就是在为payload添加各种标准声明和私有声明了
		//这里其实就是new一个JwtBuilder，设置jwt的body
		JwtBuilder builder = Jwts.builder()
				//如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
				.setClaims(claims)
				//设置jti(JWT ID)：是JWT的唯一标识，主要用来作为一次性token,从而回避重放攻击。
				.setId(UUID.randomUUID().toString())
				//iat: jwt的签发时间
				.setIssuedAt(new Date())
				//代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串
				.setSubject(subject)
				//设置签名使用的签名算法和签名使用的秘钥
				.signWith(signatureAlgorithm, key)
				//
				.setExpiration(expirationDate);
		return builder.compact();
	}


	/**
	 * Token的解密
	 * @param token 加密后的token
	 * @param user  用户的对象
	 * @return
	 */
	public static Claims parseJWT(String token, JwtUser user) {
		//签名秘钥，和生成的签名的秘钥一模一样
		String key = user.getPassword();

		//得到DefaultJwtParser
		Claims claims = Jwts.parser()
				//设置签名的秘钥
				.setSigningKey(key)
				//设置需要解析的jwt
				.parseClaimsJws(token).getBody();
		return claims;
	}

	@Data
	@Builder
	@Api("jwt专属用户类")
	@AllArgsConstructor
	@NoArgsConstructor
	public static class JwtUser {
		private String id;
		private String name;
		private String password;
	}
}
