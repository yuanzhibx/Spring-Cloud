package com.yanbingxu.sp09.feign;

import com.yanbingxu.sp01.pojo.Item;
import com.yanbingxu.web.util.JsonResult;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Yuanzhibx
 * @Date 2020-08-04
 */
@Component
public class ItemFeignClientFB implements ItemFeignClient {

    @Override
    public JsonResult<List<Item>> getItems(String orderId) {
        return JsonResult.err().msg("获取订单商品列表失败~~~");
    }

    @Override
    public JsonResult<?> decreaseNumber(List<Item> items) {
        return JsonResult.err().msg("修改商品库存失败~~~");
    }

}
