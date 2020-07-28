package com.yanbingxu.sp01.service;

import com.yanbingxu.sp01.pojo.Order;

/**
 * @author Yuanzhibx
 * @Date 2020-07-28
 */
public interface OrderService {

    /**
     * 查询订单
     *
     * @param orderId 订单 id
     * @return Order 订单信息
     */
    Order getOrder(String orderId);

    /**
     * 添加订单
     *
     * @param order 订单信息
     */
    void addOrder(Order order);

}
