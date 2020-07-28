package com.yanbingxu.sp04.order.service;

import com.yanbingxu.sp01.pojo.Order;
import com.yanbingxu.sp01.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Yuanzhibx
 * @Date 2020-07-28
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    /**
     * 查询订单
     *
     * @param orderId 订单 id
     * @return Order 订单信息
     */
    @Override
    public Order getOrder(String orderId) {
        //TODO: 调用用户, 获取用户
        //TODO: 调用商品, 获取商品列表
        Order order = new Order();
        order.setId(orderId);
        return order;
    }

    /**
     * 添加订单
     *
     * @param order 订单信息
     */
    @Override
    public void addOrder(Order order) {
        //TODO 调用用户, 增加用户积分
        //TODO 调用商品, 减少商品库存
        log.info("保存订单: " + order);
    }

}
