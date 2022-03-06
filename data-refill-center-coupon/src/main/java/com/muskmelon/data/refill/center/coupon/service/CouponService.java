package com.muskmelon.data.refill.center.coupon.service;

import com.muskmelon.data.refill.center.coupon.api.CouponServiceApi;
import com.muskmelon.data.refill.center.coupon.domain.Coupon;
import com.muskmelon.data.refill.center.coupon.mapper.CouponMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author muskmelon
 * @since 1.0
 */
@RestController
public class CouponService implements CouponServiceApi {

    @Resource
    private CouponMapper couponMapper;

    @Override
    public Coupon queryByUserAccountId(@PathVariable("userAccountId") Long userAccountId) {
        return couponMapper.queryByUserAccountId(userAccountId);
    }

    @Override
    public void markCouponUsed(@RequestParam Long couponId) {
        couponMapper.updateCouponStatus(couponId, 2);
    }

    @Override
    public void insertCoupon(@RequestBody Coupon coupon) {
        couponMapper.insertCoupon(coupon);
    }
}
