package com.muskmelon.data.refill.center.lottery.api;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author muskmelon
 * @since 1.0
 */
@RequestMapping("/lotteryDraw")
public interface LotteryDrawApi {

    @PostMapping("/updateLotteryDrawCount")
    void updateLotteryDrawCount(@RequestParam Long userAccountId);
}
