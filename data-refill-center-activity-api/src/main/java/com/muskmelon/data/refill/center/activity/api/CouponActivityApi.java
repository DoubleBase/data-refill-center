package com.muskmelon.data.refill.center.activity.api;


import com.muskmelon.data.refill.center.activity.domain.CouponActivity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author muskmelon
 * @since 1.0
 */
@RequestMapping("/activity/coupon")
public interface CouponActivityApi {

    /**
     * 查询流量绑定的促销活动
     *
     * @return 流量包ID
     */
    @GetMapping(value = "/{dataPackageId}")
    CouponActivity queryByDataPackageId(@PathVariable("dataPackageId") Long dataPackageId);


}
