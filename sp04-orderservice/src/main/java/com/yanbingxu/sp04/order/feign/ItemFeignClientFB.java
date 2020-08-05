package com.yanbingxu.sp04.order.feign;

import com.yanbingxu.sp01.pojo.Item;
import com.yanbingxu.web.util.JsonResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuanzhibx
 * @Date 2020-08-05
 */
@Component
public class ItemFeignClientFB implements ItemFeignClient {

    @Override
    public JsonResult<List<Item>> getItems(String orderId) {
        // 模拟有缓存数据, 返回缓存
        if (Math.random() < 0.5) {
            ArrayList<Item> items = new ArrayList<>();
            items.add(new Item(1, "商品 1", 2));
            items.add(new Item(2, "商品 2", 3));
            items.add(new Item(3, "商品 3", 5));
            items.add(new Item(4, "商品 4", 1));
            items.add(new Item(5, "商品 5", 7));

        }
        return JsonResult.err().msg("获取商品的商品列表失败~~~");
    }

    @Override
    public JsonResult<List<Item>> decreaseNumber(List<Item> items) {
        return JsonResult.err().msg("减少商品库存失败~~~");
    }

}
