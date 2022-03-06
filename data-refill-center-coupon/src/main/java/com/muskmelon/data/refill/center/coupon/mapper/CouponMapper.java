package com.muskmelon.data.refill.center.coupon.mapper;

import com.muskmelon.data.refill.center.coupon.domain.Coupon;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author muskmelon
 * @since 1.0
 */
@Mapper
public interface CouponMapper {

    @Select("select * from coupon where user_account_id=#{userAccountId} " +
            "and status = 1 order by coupon_amount desc limit 1")
    @Results({
            @Result(column = "user_account_id", property = "userAccountId"),
            @Result(column = "coupon_amount", property = "couponAmount"),
            @Result(column = "start_time", property = "startTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "status", property = "status"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "modified_time", property = "modifiedTime")
    })
    Coupon queryByUserAccountId(@Param("userAccountId") Long userAccountId);

    @Update("update coupon set status = #{status} where id = #{couponId}")
    int updateCouponStatus(@Param("couponId") Long couponId,
                           @Param("status") Integer status);

    @Insert("insert into coupon (" +
            "user_account_id," +
            "coupon_amount," +
            "start_time," +
            "end_time," +
            "status)" +
            "values(" +
            "#{userAccountId}," +
            "#{couponAmount}," +
            "#{startTime}," +
            "#{endTime}," +
            "#{status})")
    void insertCoupon(Coupon coupon);
}
