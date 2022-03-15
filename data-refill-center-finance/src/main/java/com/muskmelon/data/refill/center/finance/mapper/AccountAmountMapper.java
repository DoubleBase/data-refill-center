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

    @Update("update account_amount set " +
            "amount = amount + #{updateAmount} " +
            "where user_account_id=#{userAccountId}")
    void updateAmount(@Param("userAccountId") Long userAccountId,
                      @Param("updateAmount") Long updateAmount);

    @Update("update account_amount set " +
            "amount = amount - #{updateAmount}," +
            "locked_amount = locked_amount + #{updateAmount} " +
            "where user_account_id=#{userAccountId}")
    void tryTransferOut(@Param("userAccountId") Long userAccountId,
                        @Param("updateAmount") Long updateAmount);

    @Update("update account_amount set " +
            "locked_amount = locked_amount + #{updateAmount} " +
            "where user_account_id=#{userAccountId}")
    void tryTransferIn(@Param("userAccountId") Long userAccountId,
                       @Param("updateAmount") Long updateAmount);

    @Update("update account_amount set " +
            "locked_amount = locked_amount - #{updateAmount} " +
            "where user_account_id=#{userAccountId}")
    void confirmTransferOut(@Param("userAccountId") Long userAccountId,
                            @Param("updateAmount") Long updateAmount);

    @Update("update account_amount set " +
            "amount = amount + #{updatedAmount} " +
            "locked_amount = locked_amount - #{updateAmount} " +
            "where user_account_id=#{userAccountId}")
    void confirmTransferIn(@Param("userAccountId") Long userAccountId,
                           @Param("updateAmount") Long updateAmount);

    @Update("update account_amount set " +
            "amount = amount + #{updateAmount}," +
            "locked_amount = locked_amount - #{updateAmount} " +
            "where user_account_id=#{userAccountId}")
    void cancelTransferOut(@Param("userAccountId") Long userAccountId,
                           @Param("updateAmount") Long updateAmount);

    @Update("update account_amount set " +
            "locked_amount = locked_amount - #{updateAmount} " +
            "where user_account_id=#{userAccountId}")
    void cancelTransferIn(@Param("userAccountId") Long userAccountId,
                           @Param("updateAmount") Long updateAmount);
}
