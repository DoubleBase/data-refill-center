package com.muskmelon.data.refill.center.service.impl;

import com.muskmelon.data.refill.center.domain.RefillOrder;
import com.muskmelon.data.refill.center.mapper.order.RefillOrderMapper;
import com.muskmelon.data.refill.center.service.RefillOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author muskmelon
 * @since 1.0
 */
@Service
public class RefillOrderServiceImpl implements RefillOrderService {

    @Resource
    private RefillOrderMapper refillOrderMapper;

    @Override
    public void insertOrder(RefillOrder refillOrder) {
        refillOrderMapper.insertOrder(refillOrder);
    }

    @Override
    public List<RefillOrder> queryAllOrder(Long userAccountId) {
        return refillOrderMapper.queryAll(userAccountId);
    }

    @Override
    public RefillOrder queryById(Long id) {
        return refillOrderMapper.queryById(id);
    }

}
