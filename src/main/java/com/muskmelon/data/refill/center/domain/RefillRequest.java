package com.muskmelon.data.refill.center.domain;

import lombok.Data;

/**
 * @author muskmelon
 * @since 1.0
 */
@Data
public class RefillRequest {

    private Long userAccountId;

    private Long businessAccountId;

    private String businessName;

    private Long payAmount;

    private String phoneNumber;

    private DataPackage dataPackage;

    private Coupon coupon;

}
