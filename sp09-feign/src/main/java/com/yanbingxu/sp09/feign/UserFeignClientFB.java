package com.yanbingxu.sp09.feign;

import com.yanbingxu.sp01.pojo.User;
import com.yanbingxu.web.util.JsonResult;
import org.springframework.stereotype.Component;

/**
 * @author Yuanzhibx
 * @Date 2020-08-04
 */
@Component
public class UserFeignClientFB implements UserFeignClient {

    @Override
    public JsonResult<User> getUser(Integer userId) {
        return JsonResult.err().msg("获取用户信息失败~~~");
    }

    @Override
    public JsonResult<?> addScore(Integer userId, Integer score) {
        return JsonResult.err().msg("增加用户积分失败~~~");
    }

}
