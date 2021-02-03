package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

	private final JdbcTemplate jdbcTemplate;

	@Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

   
    @Override
    public MyUser findUserByUserName(String userName) {
        String sql = "SELECT user_name, password, name, role_name FROM login_user WHERE user_name = ?";

        //ユーザを一件取得
        Map<String, Object> result = jdbcTemplate.queryForMap(sql, userName);

        // Entityクラス(User型)に変換
        MyUser user = convMapToUser(result);

        return user;
    }

   
    private MyUser convMapToUser(Map<String, Object> map) {
        MyUser user = new MyUser();

        user.setUserName((String) map.get("user_name"));
        user.setPassword((String) map.get("password"));
        user.setName((String) map.get("name"));
        user.setRoleName((String) map.get("role_name"));

        return user;
    }
}
