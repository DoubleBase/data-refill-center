package com.muskmelon.data.refill.center.lottery.service;

import com.muskmelon.data.refill.center.lottery.mapper.LotteryDrawMapper;
import com.muskmelon.data.refill.center.lottery.api.LotteryDrawApi;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author muskmelon
 * @since 1.0
 */
@RestController
public class LotteryDrawService implements LotteryDrawApi {

    @Resource
    private LotteryDrawMapper lotteryDrawMapper;

    @Override
    public void updateLotteryDrawCount(@RequestParam Long userAccountId) {
        lotteryDrawMapper.updateLotteryDrawCount(userAccountId);
    }
}
