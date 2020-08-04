package com.yanbingxu.sp09.feign;

import com.yanbingxu.sp01.pojo.Item;
import com.yanbingxu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Yuanzhibx
 * @Date 2020-08-04
 */
@FeignClient(name = "item-service", fallback = ItemFeignClientFB.class)
public interface ItemFeignClient {

    /**
     * 商品服务
     * 根据订单 id, 获取订单的商品列表
     *
     * @param orderId 订单 id
     * @return
     */
    @GetMapping("/{orderId}")
    JsonResult<List<Item>> getItems(@PathVariable String orderId);

    /**
     * 商品服务
     * 减少商品库存
     *
     * @param items 商品信息集合
     * @return
     */
    @PostMapping("/decreaseNumber")
    JsonResult<?> decreaseNumber(@RequestBody List<Item> items);

}
