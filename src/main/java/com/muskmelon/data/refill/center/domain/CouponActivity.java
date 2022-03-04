package com.muskmelon.data.refill.center.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author muskmelon
 * @since 1.0
 */
@Data
public class CouponActivity {

    private Long id;

    private Long dataPackageId;

    private Long couponAmount;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    private Integer status;

    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;

}
