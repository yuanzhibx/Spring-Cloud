package com.yanbingxu.sp04.order.feign;

import com.yanbingxu.sp01.pojo.User;
import com.yanbingxu.web.util.JsonResult;
import org.springframework.stereotype.Component;

/**
 * @author Yuanzhibx
 * @Date 2020-08-05
 */
@Component
public class UserFeignClientFB implements UserFeignClient {

    @Override
    public JsonResult<User> getUser(Integer userId) {
        // 模拟有缓存数据, 返回缓存
        if (Math.random() < 0.5) {
            User user = new User(userId, "缓存用户" + userId, "缓存密码" + userId);
            return JsonResult.ok().data(user);
        }
        return JsonResult.err().msg("获取订单的商品列表失败");
    }

    @Override
    public JsonResult<?> addScore(Integer userId, Integer score) {
        return JsonResult.err().msg("添加积分失败");
    }

}
