package com.yanbingxu.sp09.feign;

import com.yanbingxu.sp01.pojo.Order;
import com.yanbingxu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Yuanzhibx
 * @Date 2020-08-04
 */
@FeignClient(name = "order-service", fallback = OrderFeignClientFB.class)
public interface OrderFeignClient {

    /**
     * 订单服务
     * 根据订单 id, 查询订单信息
     *
     * @param orderId 订单 id
     * @return
     */
    @GetMapping("/{orderId}")
    JsonResult<Order> getOrder(@PathVariable String orderId);

    /**
     * 订单服务
     * 新增订单
     *
     * @return
     */
    @GetMapping("/")
    JsonResult<?> addOrder();

}
