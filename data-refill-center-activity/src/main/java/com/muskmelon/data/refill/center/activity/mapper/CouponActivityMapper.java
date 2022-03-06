package com.muskmelon.data.refill.center.activity.mapper;

import com.muskmelon.data.refill.center.activity.domain.CouponActivity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author muskmelon
 * @since 1.0
 */
@Mapper
public interface CouponActivityMapper {

    @Select("select * from coupon_activity where data_package_id=#{dataPackageId} " +
            "and status = 2")
    @Results({
            @Result(column = "data_package_id", property = "dataPackageId"),
            @Result(column = "coupon_amount", property = "couponAmount"),
            @Result(column = "start_time", property = "startTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "status", property = "status"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "modified_time", property = "modifiedTime")
    })
    CouponActivity queryByDataPackageId(@Param("dataPackageId") Long dataPackageId);

}
