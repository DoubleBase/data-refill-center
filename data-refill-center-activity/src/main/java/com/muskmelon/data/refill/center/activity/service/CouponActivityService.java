package com.muskmelon.data.refill.center.activity.service;

import com.muskmelon.data.refill.center.activity.api.CouponActivityApi;
import com.muskmelon.data.refill.center.activity.domain.CouponActivity;
import com.muskmelon.data.refill.center.activity.mapper.CouponActivityMapper;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author muskmelon
 * @since 1.0
 */
@RestController
public class CouponActivityService implements CouponActivityApi {

    @Resource
    private CouponActivityMapper couponActivityMapper;

    @Override
    public CouponActivity queryByDataPackageId(
            @PathVariable("dataPackageId") Long dataPackageId) {
        return couponActivityMapper.queryByDataPackageId(dataPackageId);
    }
}
