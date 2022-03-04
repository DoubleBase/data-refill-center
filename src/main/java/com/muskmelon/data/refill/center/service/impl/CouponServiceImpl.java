package com.muskmelon.data.refill.center.service.impl;

import com.muskmelon.data.refill.center.domain.Coupon;
import com.muskmelon.data.refill.center.mapper.coupon.CouponMapper;
import com.muskmelon.data.refill.center.service.CouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author muskmelon
 * @since 1.0
 */
@Service
public class CouponServiceImpl implements CouponService {

    @Resource
    private CouponMapper couponMapper;

    @Override
    public Coupon queryByUserAccountId(Long userAccountId) {
        return couponMapper.queryByUserAccountId(userAccountId);
    }

    @Override
    public void markCouponUsed(Long couponId) {
        couponMapper.updateCouponStatus(couponId, 2);
    }

    @Override
    public void insertCoupon(Coupon coupon) {
        couponMapper.insertCoupon(coupon);
    }
}
