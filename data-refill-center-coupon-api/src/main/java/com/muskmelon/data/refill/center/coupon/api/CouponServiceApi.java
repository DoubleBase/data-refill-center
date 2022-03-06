package com.muskmelon.data.refill.center.coupon.api;

import com.muskmelon.data.refill.center.coupon.domain.Coupon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author muskmelon
 * @since 1.0
 */
@RequestMapping("/coupon")
public interface CouponServiceApi {

    @GetMapping("/queryByUserAccountId/{userAccountId}")
    Coupon queryByUserAccountId(@PathVariable("userAccountId") Long userAccountId);

    @PostMapping("/markCouponUsed")
    void markCouponUsed(@RequestParam Long couponId);

    @PostMapping("/insertCoupon")
    void insertCoupon(@RequestBody Coupon coupon);

}
