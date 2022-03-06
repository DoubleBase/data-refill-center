package com.muskmelon.data.refill.center.activity.api;


import com.muskmelon.data.refill.center.activity.domain.PromotionActivity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author muskmelon
 * @since 1.0
 */
@RequestMapping("/activity/promotion")
public interface PromotionActivityApi {

    /**
     * 查询流量绑定的促销活动
     *
     * @return 流量包ID
     */
    @GetMapping(value = "/{dataPackageId}")
    PromotionActivity queryByDataPackageId(@PathVariable("dataPackageId") Long dataPackageId);


}
