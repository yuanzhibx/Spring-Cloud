package com.yanbingxu.sp04.order.controller;

import com.yanbingxu.sp01.pojo.Item;
import com.yanbingxu.sp01.pojo.Order;
import com.yanbingxu.sp01.pojo.User;
import com.yanbingxu.sp01.service.OrderService;
import com.yanbingxu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author Yuanzhibx
 * @Date 2020-07-28
 */
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询订单
     *
     * @param orderId 订单 id
     * @return
     */
    @GetMapping("/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId) {
        log.info("get order, id=" + orderId);
        Order order = orderService.getOrder(orderId);
        return JsonResult.ok().data(order);
    }

    /**
     * 新增订单
     *
     * @return
     */
    @GetMapping("/")
    public JsonResult addOrder() {
        Order order = new Order();
        order.setId("777729");
        order.setUser(new User(7, null, null));
        order.setItems(Arrays.asList(new Item[] {
                new Item(1, "Yuanzhibx", 2),
                new Item(2, "bbb", 1),
                new Item(3, "ccc", 9),
                new Item(4, "ddd", 3),
                new Item(5, "eee", 2),
        }));
        orderService.addOrder(order);
        return JsonResult.ok();
    }

}
