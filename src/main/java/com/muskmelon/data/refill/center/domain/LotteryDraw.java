package com.muskmelon.data.refill.center.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author muskmelon
 * @since 1.0
 */
@Data
public class LotteryDraw {

    private Long id;
    private Long userAccountId;
    private Long lotteryDrawCount;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;


}
