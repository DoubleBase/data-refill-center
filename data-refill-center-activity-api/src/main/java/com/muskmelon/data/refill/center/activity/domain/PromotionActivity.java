package com.muskmelon.data.refill.center.activity.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author muskmelon
 * @since 1.0
 */
@Data
public class PromotionActivity {

    private Long id;

    private Long dataPackageId;

    private Long discountPrice;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;

}
