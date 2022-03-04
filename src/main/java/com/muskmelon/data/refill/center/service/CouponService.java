package com.muskmelon.data.refill.center.service;

import com.muskmelon.data.refill.center.domain.Coupon;

/**
 * @author muskmelon
 * @since 1.0
 */
public interface CouponService {

    Coupon queryByUserAccountId(Long userAccountId);

    void markCouponUsed(Long couponId);

    void insertCoupon(Coupon coupon);

}
