package com.muskmelon.data.refill.center.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 充值订单
 *
 * @author muskmelon
 * @since 1.0
 */
@Data
public class RefillOrder {

    private Long id;
    private String orderNo;
    private Long userAccountId;
    private Long businessAccountId;
    private String businessName;
    private Long amount;
    private String title;
    private String type;
    private Integer status;
    private Integer payType;
    private String refillComment;
    private String refillPhoneNumber;
    private Integer refillData;
    private Long credit;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;

}
