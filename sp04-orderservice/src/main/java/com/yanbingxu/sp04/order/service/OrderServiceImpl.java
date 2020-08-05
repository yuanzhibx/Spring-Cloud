package com.yanbingxu.sp04.order.service;

import com.yanbingxu.sp01.pojo.Item;
import com.yanbingxu.sp01.pojo.Order;
import com.yanbingxu.sp01.pojo.User;
import com.yanbingxu.sp01.service.OrderService;
import com.yanbingxu.sp04.order.feign.ItemFeignClient;
import com.yanbingxu.sp04.order.feign.UserFeignClient;
import com.yanbingxu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yuanzhibx
 * @Date 2020-07-28
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ItemFeignClient itemFeignClient;

    @Autowired
    private UserFeignClient userFeignClient;

    /**
     * 查询订单
     *
     * @param orderId 订单 id
     * @return Order 订单信息
     */
    @Override
    public Order getOrder(String orderId) {
        // 调用用户, 获取用户 (真实项目中, 要获得已登录的用户 id)
        JsonResult<User> user = userFeignClient.getUser(8);
        // 调用商品, 获取商品列表
        JsonResult<List<Item>> items = itemFeignClient.getItems(orderId);

        Order order = new Order();
        order.setId(orderId);
        order.setUser(user.getData());
        order.setItems(items.getData());
        return order;
    }

    /**
     * 添加订单
     *
     * @param order 订单信息
     */
    @Override
    public void addOrder(Order order) {
        // 调用用户, 增加用户积分
        userFeignClient.addScore(order.getUser().getId(), 1000);
        // 调用商品, 减少商品库存
        itemFeignClient.decreaseNumber(order.getItems());

        log.info("保存订单: " + order);
    }

}
