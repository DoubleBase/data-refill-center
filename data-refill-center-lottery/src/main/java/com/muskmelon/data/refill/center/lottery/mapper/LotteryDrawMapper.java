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

    @Update("update lottery_draw set " +
            "locked_count = locked_count + 1 " +
            "where user_account_id = #{userAccountId}")
    void tryUpdateLotteryCount(@Param("userAccountId") Long userAccountId);

    @Update("update lottery_draw set " +
            "lottery_draw_count = lottery_draw_count + 1 " +
            "locked_count = locked_count - 1 " +
            "where user_account_id = #{userAccountId}")
    void confirmUpdateLotteryCount(@Param("userAccountId") Long userAccountId);

    @Update("update lottery_draw set " +
            "locked_count = locked_count - 1 " +
            "where user_account_id = #{userAccountId}")
    void cancelUpdateLotteryCount(@Param("userAccountId") Long userAccountId);
}
