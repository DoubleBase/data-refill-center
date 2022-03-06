package com.muskmelon.data.refill.center.service.api;

import com.muskmelon.data.refill.center.lottery.api.LotteryDrawApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("data-refill-center-lottery")
public interface LotteryDrawService extends LotteryDrawApi {

}
