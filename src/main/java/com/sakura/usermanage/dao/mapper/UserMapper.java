package com.sakura.usermanage.dao.mapper;

import com.sakura.usermanage.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    List<User> select(Map<String, Object> map);
}
