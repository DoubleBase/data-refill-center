package com.muskmelon.data.refill.center.service.api;


import com.muskmelon.data.refill.center.order.api.RefillOrderApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("data-refill-center-order")
public interface RefillOrderService extends RefillOrderApi {

}
