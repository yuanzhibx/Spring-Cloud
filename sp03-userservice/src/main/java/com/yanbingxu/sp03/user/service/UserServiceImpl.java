package com.yanbingxu.sp03.user.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.yanbingxu.sp01.pojo.User;
import com.yanbingxu.sp01.service.UserService;
import com.yanbingxu.web.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yuanzhibx
 * @Date 2020-07-28
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Value("${sp.user-service.users}")
    private String userJson;

    /**
     * 查询用户
     *
     * @param id 用户 id
     * @return User 用户信息
     */
    @Override
    public User getUser(Integer id) {
        List<User> list = JsonUtil.from(userJson, new TypeReference<List<User>>() {});
        for (User user : list) {
            if (id.equals(user.getId())) {
                return user;
            }
        }
        return new User(id, "name-- " + id, "pwd--" + id);
    }

    /**
     * 添加用户积分
     *
     * @param id    用户 id
     * @param score 积分
     */
    @Override
    public void addScore(Integer id, Integer score) {
        log.info("user: " + id + " - 增加积分" + score);
    }

}
