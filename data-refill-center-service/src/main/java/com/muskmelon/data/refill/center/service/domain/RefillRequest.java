package com.muskmelon.data.refill.center.service.domain;

import com.muskmelon.data.refill.center.coupon.domain.Coupon;
import com.muskmelon.data.refill.center.datapackage.domain.DataPackage;
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
