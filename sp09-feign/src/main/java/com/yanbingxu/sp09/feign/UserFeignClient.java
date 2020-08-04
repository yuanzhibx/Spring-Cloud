package com.yanbingxu.sp09.feign;

import com.yanbingxu.sp01.pojo.User;
import com.yanbingxu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Yuanzhibx
 * @Date 2020-08-04
 */
@FeignClient(name = "user-service", fallback = UserFeignClientFB.class)
public interface UserFeignClient {

    /**
     * 用户服务
     * 根据用户 id, 获取用户信息
     *
     * @param userId 用户 id
     * @return
     */
    @GetMapping("/{userId}")
    JsonResult<User> getUser(@PathVariable Integer userId);

    /**
     * 用户服务
     * 添加积分
     *
     * @param userId 用户 id
     * @param score  积分
     * @return
     */
    @GetMapping("/{userId}/score")
    JsonResult<?> addScore(@PathVariable Integer userId, @RequestParam Integer score);

}
