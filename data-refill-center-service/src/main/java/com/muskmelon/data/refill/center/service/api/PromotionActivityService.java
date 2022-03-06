package com.muskmelon.data.refill.center.service.api;

import com.muskmelon.data.refill.center.activity.api.PromotionActivityApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("data-refill-center-activity")
public interface PromotionActivityService extends PromotionActivityApi {

}
