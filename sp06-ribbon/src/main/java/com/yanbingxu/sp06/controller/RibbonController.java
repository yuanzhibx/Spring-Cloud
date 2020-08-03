package com.yanbingxu.sp06.controller;

import com.yanbingxu.sp01.pojo.Item;
import com.yanbingxu.sp01.pojo.Order;
import com.yanbingxu.sp01.pojo.User;
import com.yanbingxu.web.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.Path;
import java.util.List;

/**
 * @author Yuanzhibx
 * @Date 2020-07-31
 */
@RestController
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 商品服务
     * 根据订单 id, 获取订单的商品列表
     * 从 eureka 可得到 "item-service" 对应的主机地址列表: localhost:8001, localhost:8002
     *
     * @param orderId 订单 id
     * @return
     */
    @GetMapping("/item-service/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
        return restTemplate.getForObject("http://item-service/{1}", JsonResult.class, orderId);
    }

    /**
     * 商品服务
     * 减少商品库存
     *
     * @param items 商品信息集合
     * @return
     */
    @PostMapping("/item-service/decreaseNumber")
    public JsonResult<?> decreaseNumber(@RequestBody List<Item> items) {
        return restTemplate.postForObject("http://item-service/decreaseNumber", items, JsonResult.class);
    }

    /**
     * 用户服务
     * 根据用户 id, 获取用户信息
     *
     * @param userId 用户 id
     * @return
     */
    @GetMapping("/user-service/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId) {
        return restTemplate.getForObject("http://user-service/{1}", JsonResult.class, userId);
    }

    /**
     * 用户服务
     * 添加积分
     *
     * @param userId 用户 id
     * @param score  积分
     * @return
     */
    @GetMapping("/user-service/{userId}/score")
    public JsonResult<?> addScore(@PathVariable Integer userId, Integer score) {
        return restTemplate.getForObject("http://user-service/{1}/score?score={2}", JsonResult.class, userId, score);
    }

    /**
     * 订单服务
     * 根据订单 id, 查询订单信息
     *
     * @param orderId 订单 id
     * @return
     */
    @GetMapping("/order-service/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId) {
        return restTemplate.getForObject("http://order-service/{1}", JsonResult.class, orderId);
    }

    /**
     * 订单服务
     * 新增订单
     *
     * @return
     */
    @GetMapping("/order-service/")
    public JsonResult<?> addOrder() {
        return restTemplate.getForObject("http://order-service/", JsonResult.class);
    }

}
