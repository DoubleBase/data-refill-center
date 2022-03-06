package com.muskmelon.data.refill.center.service.api;

import com.muskmelon.data.refill.center.activity.api.CouponActivityApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author muskmelon
 * @since 1.0
 */
@FeignClient("data-refill-center-activity")
public interface CouponActivityService extends CouponActivityApi {

}
