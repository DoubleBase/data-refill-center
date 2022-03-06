package com.muskmelon.data.refill.center.service.api;

import com.muskmelon.data.refill.center.finance.api.AccountAmountApi;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient("data-refill-center-finance")
public interface AccountAmountService extends AccountAmountApi {

}
