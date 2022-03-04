package com.muskmelon.data.refill.center.service;

import com.muskmelon.data.refill.center.domain.DataPackage;
import com.muskmelon.data.refill.center.domain.PromotionActivity;

import java.util.List;

/**
 * @author muskmelon
 * @since 1.0
 */
public interface PromotionActivityService {

    /**
     * 查询流量绑定的促销活动
     *
     * @return 流量包ID
     */
    PromotionActivity queryByDataPackageId(Long dataPackageId);


}
