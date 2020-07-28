package com.yanbingxu.sp01.service;

import com.yanbingxu.sp01.pojo.Item;

import java.util.List;

/**
 * @author Yuanzhibx
 * @Date 2020-07-28
 */
public interface ItemService {

    /**
     * 查询订单中的商品列表
     *
     * @param orderId 订单 id
     * @return 商品列表
     */
    List<Item> getItems(String orderId);

    /**
     * 减少商品的库存
     *
     * @param list 商品列表
     */
    void decreaseNumbers(List<Item> list);

}
