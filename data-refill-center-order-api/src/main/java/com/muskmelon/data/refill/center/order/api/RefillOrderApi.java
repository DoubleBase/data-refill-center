package com.muskmelon.data.refill.center.order.api;


import com.muskmelon.data.refill.center.order.domain.RefillOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author muskmelon
 * @since 1.0
 */
@RequestMapping("/refillOrder")
public interface RefillOrderApi {

    @PostMapping("/insertOrder")
    void insertOrder(@RequestBody RefillOrder refillOrder);

    @GetMapping("/queryAllOrder/{userAccountId}")
    List<RefillOrder> queryAllOrder(@PathVariable("userAccountId") Long userAccountId);

    @GetMapping("/queryById/{id}")
    RefillOrder queryById(@PathVariable("id") Long id);
}
