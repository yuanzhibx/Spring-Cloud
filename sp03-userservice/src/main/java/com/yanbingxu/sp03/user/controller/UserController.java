package com.yanbingxu.sp03.user.controller;

import com.yanbingxu.sp01.pojo.User;
import com.yanbingxu.sp01.service.UserService;
import com.yanbingxu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yuanzhibx
 * @Date 2020-07-28
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户
     *
     * @param userId 用户 id
     * @return JsonResult
     */
    @GetMapping("/{userId}")
    public JsonResult getUser(@PathVariable Integer userId) {
        log.info("get user, userId = " + userId);
        User user = userService.getUser(userId);
        return JsonResult.ok(user).data(user);
    }

    /**
     * 添加用户积分
     * url: /8/score?score=1000
     *
     * @param userId 用户 id
     * @param score 积分
     * @return
     */
    @GetMapping("/{userId}/score")
    public JsonResult addScore(@PathVariable Integer userId, Integer score) {
        userService.addScore(userId, score);
        return JsonResult.ok().msg("添加用户积分成功~~~");
    }

}
