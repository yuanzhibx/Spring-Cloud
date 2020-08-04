package com.yanbingxu.sp09.controller;

import com.yanbingxu.sp01.pojo.Item;
import com.yanbingxu.sp01.pojo.Order;
import com.yanbingxu.sp01.pojo.User;
import com.yanbingxu.sp09.feign.ItemFeignClient;
import com.yanbingxu.sp09.feign.OrderFeignClient;
import com.yanbingxu.sp09.feign.UserFeignClient;
import com.yanbingxu.web.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yuanzhibx
 * @Date 2020-08-04
 */
@RestController
public class FeignController {

    @Autowired
    private ItemFeignClient itemFeignClient;

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private OrderFeignClient orderFeignClient;

    @GetMapping("/item-service/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
        return itemFeignClient.getItems(orderId);
    }

    @GetMapping("/item-service/decreaseNumber")
    public JsonResult<?> decreaseNumber(@PathVariable List<Item> items) {
        return itemFeignClient.decreaseNumber(items);
    }

    @GetMapping("/user-service/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId) {
        return userFeignClient.getUser(userId);
    }

    @GetMapping("/user-service/{userId}/score")
    public JsonResult<?> addScore(@PathVariable Integer userId, Integer score) {
        return userFeignClient.addScore(userId, score);
    }

    @GetMapping("/order-service/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId) {
        return orderFeignClient.getOrder(orderId);
    }

    @GetMapping("/order-service/")
    public JsonResult<?> addOrder() {
        return orderFeignClient.addOrder();
    }

}
