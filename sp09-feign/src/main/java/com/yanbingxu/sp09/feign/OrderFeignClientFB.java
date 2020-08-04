package com.yanbingxu.sp09.feign;

import com.yanbingxu.sp01.pojo.Order;
import com.yanbingxu.web.util.JsonResult;
import org.springframework.stereotype.Component;

/**
 * @author Yuanzhibx
 * @Date 2020-08-04
 */
@Component
public class OrderFeignClientFB implements OrderFeignClient {

    @Override
    public JsonResult<Order> getOrder(String orderId) {
        return JsonResult.err().msg("获取商品订单失败~~~");
    }

    @Override
    public JsonResult<?> addOrder() {
        return JsonResult.err().msg("保存订单失败~~~");
    }

}
