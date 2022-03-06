package com.muskmelon.data.refill.center.service.api;

import com.muskmelon.data.refill.center.coupon.api.CouponServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("data-refill-center-coupon")
public interface CouponService extends CouponServiceApi {

}
