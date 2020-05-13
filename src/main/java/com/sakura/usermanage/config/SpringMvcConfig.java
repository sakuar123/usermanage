package com.sakura.usermanage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by 李七夜 on 2020/5/8 19:46
 */
public class SpringMvcConfig implements WebMvcConfigurer {
	@Autowired
	private ServerProperties serverProperties;
}
