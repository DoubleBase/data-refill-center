package com.muskmelon.data.refill.center.datapackage.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.muskmelon.data.refill.center.activity.domain.CouponActivity;
import com.muskmelon.data.refill.center.activity.domain.PromotionActivity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author muskmelon
 * @since 1.0
 */
@Data
public class DataPackage {

    /**
     * id
     */
    private Long id;
    /**
     * 流量
     */
    private Integer data;
    /**
     * 价格
     */
    private Long price;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 说明
     */
    private String comment;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedTime;

    /**
     * 优惠券活动
     */
    private CouponActivity couponActivity;

    /**
     * 促销活动
     */
    private PromotionActivity promotionActivity;

}
