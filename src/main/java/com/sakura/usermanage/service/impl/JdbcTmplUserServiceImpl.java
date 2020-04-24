package com.sakura.usermanage.service.impl;

import com.sakura.usermanage.entity.User;
import com.sakura.usermanage.service.JdbcTmplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 * @author 李七夜
 */
@Service
public class JdbcTmplUserServiceImpl implements JdbcTmplUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> getUserMapper() {
        RowMapper<User> userRowMapper = (ResultSet rs, int rowNum) -> {
            return User
                    .builder()
                    .id(rs.getInt("id"))
                    .address(rs.getString("address"))
                    .birthday(rs.getDate("birthday"))
                    .gender(rs.getInt("gender"))
                    .userCode(rs.getString("userCode"))
                    .userName(rs.getString("userName"))
                    .userPassword(rs.getString("userPassword"))
                    .userRole(rs.getInt("userRole"))
                    .phone(rs.getString("phone"))
                    .build();
        };
        return userRowMapper;
    }

    @Override

    public User getUser(Integer userId) {
        //执行的SQL语句
        String sql = "select * from smbms_user where id = ?";
        //参数
        Object[] params = new Object[]{userId};
        User user = jdbcTemplate.queryForObject(sql, params, getUserMapper());
        return user;
    }

    @Override
    public List<User> findUserList(String userName, Integer sex) {
        //SQL语句
        String sql = "select * from smbms_user " +
                " where userName like concat('%',?,'%') " +
                " and gender = ? ";
        //参数
        Object[] objects = new Object[]{userName, sex};
        List<User> userList = jdbcTemplate.query(sql, objects, getUserMapper());
        return userList;
    }

    @Override
    public Integer inserUser(User user) {
        String sql = "insert into smbms_user(userCode,userName,userPassword,gender,birthday,phone,address,userRole) " +
                " values(?,?,?,?,?,?,?,?)";
        Object[] params = new Object[]{user.getUserCode(), user.getUserName(), user.getUserPassword(),
                user.getGender(), user.getBirthday(), user.getPhone(), user.getAddress(), user.getUserRole()};
        return jdbcTemplate.update(sql, params);
    }

    @Override
    public Integer updateUser(User user) {
        return null;
    }

    @Override
    public Integer deleteUser(Integer userId) {
        return null;
    }
}
