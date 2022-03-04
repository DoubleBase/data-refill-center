package com.muskmelon.data.refill.center.service.impl;

import com.muskmelon.data.refill.center.domain.PromotionActivity;
import com.muskmelon.data.refill.center.mapper.activity.PromotionActivityMapper;
import com.muskmelon.data.refill.center.service.PromotionActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author muskmelon
 * @since 1.0
 */
@Service
public class PromotionActivityServiceImpl implements PromotionActivityService {

    @Resource
    private PromotionActivityMapper promotionActivityMapper;

    @Override
    public PromotionActivity queryByDataPackageId(Long dataPackageId) {
        return promotionActivityMapper.queryByDataPackageId(dataPackageId);
    }
}
