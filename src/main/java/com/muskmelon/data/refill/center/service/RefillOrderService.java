package com.muskmelon.data.refill.center.service;

import com.muskmelon.data.refill.center.domain.RefillOrder;

import java.util.List;

/**
 * @author muskmelon
 * @since 1.0
 */
public interface RefillOrderService {

    void insertOrder(RefillOrder refillOrder);

    List<RefillOrder> queryAllOrder(Long userAccountId);

    RefillOrder queryById(Long id);
}
