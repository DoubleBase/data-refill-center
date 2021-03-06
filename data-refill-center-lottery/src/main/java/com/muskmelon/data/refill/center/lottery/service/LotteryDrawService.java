package com.muskmelon.data.refill.center.lottery.service;

import com.muskmelon.data.refill.center.lottery.mapper.LotteryDrawMapper;
import com.muskmelon.data.refill.center.lottery.api.LotteryDrawApi;
import org.bytesoft.compensable.Compensable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author muskmelon
 * @since 1.0
 */

@RestController
@Compensable(interfaceClass = LotteryDrawApi.class,
        confirmableKey = "lotteryDrawConfirmService",
        cancellableKey = "lotteryDrawCancelService")
public class LotteryDrawService implements LotteryDrawApi {

    @Resource
    private LotteryDrawMapper lotteryDrawMapper;

    @Override
    public void updateLotteryDrawCount(@RequestParam Long userAccountId) {
        lotteryDrawMapper.tryUpdateLotteryCount(userAccountId);
    }

}
