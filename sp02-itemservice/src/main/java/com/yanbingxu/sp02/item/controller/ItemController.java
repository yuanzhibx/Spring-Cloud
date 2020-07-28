package com.yanbingxu.sp02.item.controller;

import com.yanbingxu.sp01.pojo.Item;
import com.yanbingxu.sp01.service.ItemService;
import com.yanbingxu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yuanzhibx
 * @Date 2020-07-28
 */
@Slf4j
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Value("${server.port}")
    private int port;

    /**
     * 获取订单中的商品
     *
     * @param orderId 订单 id
     * @return 商品集合
     */
    @GetMapping("/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
        log.info("server.port=" + port + ", orderId=" + orderId);
        List<Item> items = itemService.getItems(orderId);
        return JsonResult.ok(items).msg("port=" + port);
    }

    /**
     * 减少商品库存
     *
     * @param items 商品集合
     * @return JsonResult
     */
    @PostMapping("/decreaseNumber")
    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
        itemService.decreaseNumbers(items);
        return JsonResult.ok().msg("减少商品库存成功");
    }

}
