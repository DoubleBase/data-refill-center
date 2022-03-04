package com.muskmelon.data.refill.center.mapper.credit;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author muskmelon
 * @since 1.0
 */
@Mapper
public interface CreditMapper {

    @Update("update credit " +
            "set point = #{point}" +
            " where user_account_id = #{userAccountId}")
    void updateCreditPoint(@Param("userAccountId") Long userAccountId,
                           @Param("point") Long point);

}
