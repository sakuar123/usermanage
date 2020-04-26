package com.sakura.usermanage.dao.generator;

import com.sakura.usermanage.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserGeneratorMapper extends tk.mybatis.mapper.common.Mapper<User> {

}
