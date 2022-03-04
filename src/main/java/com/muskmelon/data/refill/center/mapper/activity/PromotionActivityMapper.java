package com.muskmelon.data.refill.center.mapper.activity;

import com.muskmelon.data.refill.center.domain.PromotionActivity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author muskmelon
 * @since 1.0
 */
@Mapper
public interface PromotionActivityMapper {

    @Select("select * from promotion_activity where data_package_id=#{dataPackageId}" +
            " and status = 2")
    @Results({
            @Result(column = "data_package_id", property = "dataPackageId"),
            @Result(column = "discount_price", property = "discountPrice"),
            @Result(column = "start_time", property = "startTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "status", property = "status"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "modified_time", property = "modifiedTime")
    })
    PromotionActivity queryByDataPackageId(@Param("dataPackageId") Long dataPackageId);

}
