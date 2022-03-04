package com.muskmelon.data.refill.center.service.impl;

import com.muskmelon.data.refill.center.domain.CouponActivity;
import com.muskmelon.data.refill.center.mapper.activity.CouponActivityMapper;
import com.muskmelon.data.refill.center.service.CouponActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author muskmelon
 * @since 1.0
 */
@Service
public class CouponActivityServiceImpl implements CouponActivityService {

    @Resource
    private CouponActivityMapper couponActivityMapper;

    @Override
    public CouponActivity queryByDataPackageId(Long dataPackageId) {
        return couponActivityMapper.queryByDataPackageId(dataPackageId);
    }
}
