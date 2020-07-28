package com.yanbingxu.sp02.item.service;

import com.yanbingxu.sp01.pojo.Item;
import com.yanbingxu.sp01.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuanzhibx
 * @Date 2020-07-28
 */
@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    /**
     * 查询订单中的商品列表
     *
     * @param orderId 订单 id
     * @return 商品列表
     */
    @Override
    public List<Item> getItems(String orderId) {
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item(1, "商品 1", 1));
        list.add(new Item(2, "商品 2", 2));
        list.add(new Item(3, "商品 3", 3));
        list.add(new Item(4, "商品 4", 4));
        list.add(new Item(5, "商品 5", 5));
        return list;
    }

    /**
     * 减少商品的库存
     *
     * @param list 商品列表
     */
    @Override
    public void decreaseNumbers(List<Item> list) {
        for (Item item : list) {
            log.info("减少商品库存 - " + item);
        }
    }

}
