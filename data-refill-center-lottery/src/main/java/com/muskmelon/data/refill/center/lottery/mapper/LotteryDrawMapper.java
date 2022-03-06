package com.muskmelon.data.refill.center.lottery.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author muskmelon
 * @since 1.0
 */
@Mapper
public interface LotteryDrawMapper {

    @Update("update lottery_draw " +
            "set lottery_draw_count = lottery_draw_count + 1 " +
            " where user_account_id = #{userAccountId}")
    void updateLotteryDrawCount(@Param("userAccountId") Long userAccountId);

}
