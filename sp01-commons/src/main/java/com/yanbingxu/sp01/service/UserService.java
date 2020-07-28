package com.yanbingxu.sp01.service;

import com.yanbingxu.sp01.pojo.User;

/**
 * @author Yuanzhibx
 * @Date 2020-07-28
 */
public interface UserService {

    /**
     * 查询用户
     *
     * @param id 用户 id
     * @return User 用户信息
     */
    User getUser(Integer id);

    /**
     * 添加用户积分
     *
     * @param id 用户 id
     * @param score 积分
     */
    void addScore(Integer id, Integer score);

}
