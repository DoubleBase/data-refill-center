package com.muskmelon.data.refill.center.order.service;

import com.muskmelon.data.refill.center.order.domain.RefillOrder;
import com.muskmelon.data.refill.center.order.mapper.RefillOrderMapper;
import com.muskmelon.data.refill.center.order.api.RefillOrderApi;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author muskmelon
 * @since 1.0
 */
@RestController
public class RefillOrderService implements RefillOrderApi {

    @Resource
    private RefillOrderMapper refillOrderMapper;

    @Override
    public void insertOrder(@RequestBody RefillOrder refillOrder) {
        refillOrderMapper.insertOrder(refillOrder);
    }

    @Override
    public List<RefillOrder> queryAllOrder(@PathVariable("userAccountId") Long userAccountId) {
        return refillOrderMapper.queryAll(userAccountId);
    }

    @Override
    public RefillOrder queryById(@PathVariable("id") Long id) {
        return refillOrderMapper.queryById(id);
    }

}
