package com.muskmelon.data.refill.center.lottery.service;

import com.muskmelon.data.refill.center.lottery.api.LotteryDrawApi;
import com.muskmelon.data.refill.center.lottery.mapper.LotteryDrawMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author muskmelon
 * @since 1.0
 */
@Slf4j
@Service("lotteryDrawConfirmService")
@RequestMapping("/lotteryDraw/cancel")
public class LotteryDrawConfirmService implements LotteryDrawApi {

    @Resource
    private LotteryDrawMapper lotteryDrawMapper;

    @Override
    public void updateLotteryDrawCount(@RequestParam Long userAccountId) {
        lotteryDrawMapper.confirmUpdateLotteryCount(userAccountId);
        log.info("confirm 抽奖次数，userAccountId = {}", userAccountId);
    }

}
