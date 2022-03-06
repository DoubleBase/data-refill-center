package com.muskmelon.data.refill.center.finance.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author muskmelon
 * @since 1.0
 */
@Mapper
public interface AccountAmountMapper {

    @Update("update account_amount set amount = amount + #{updateAmount} where user_account_id=#{userAccountId}")
    void updateAmount(@Param("userAccountId") Long userAccountId,
                      @Param("updateAmount") Long updateAmount);
}
