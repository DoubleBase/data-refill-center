package com.muskmelon.data.refill.center.service;

/**
 * @author muskmelon
 * @since 1.0
 */
public interface AccountAmountService {

    void transfer(Long fromUserAccountId, Long toUserAccountId, Long accountAmount);

}
