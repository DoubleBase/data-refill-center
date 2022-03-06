package com.muskmelon.data.refill.center.service.api;


import com.muskmelon.data.refill.center.credit.api.CreditApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("data-refill-center-credit")
public interface CreditService extends CreditApi {

}
