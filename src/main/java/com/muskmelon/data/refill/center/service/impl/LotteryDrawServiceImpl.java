package com.muskmelon.data.refill.center.service.impl;

import com.muskmelon.data.refill.center.mapper.lottery.LotteryDrawMapper;
import com.muskmelon.data.refill.center.service.LotteryDrawService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author muskmelon
 * @since 1.0
 */
@Service
public class LotteryDrawServiceImpl implements LotteryDrawService {

    @Resource
    private LotteryDrawMapper lotteryDrawMapper;

    @Override
    public void updateLotteryDrawCount(Long userAccountId) {
        lotteryDrawMapper.updateLotteryDrawCount(userAccountId);
    }
}
