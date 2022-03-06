package com.muskmelon.data.refill.center.activity.service;

import com.muskmelon.data.refill.center.activity.api.PromotionActivityApi;
import com.muskmelon.data.refill.center.activity.domain.PromotionActivity;
import com.muskmelon.data.refill.center.activity.mapper.PromotionActivityMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author muskmelon
 * @since 1.0
 */
@RestController
public class PromotionActivityService implements PromotionActivityApi {

    @Resource
    private PromotionActivityMapper promotionActivityMapper;

    @Override
    public PromotionActivity queryByDataPackageId(@PathVariable("dataPackageId") Long dataPackageId) {
        return promotionActivityMapper.queryByDataPackageId(dataPackageId);
    }
}
