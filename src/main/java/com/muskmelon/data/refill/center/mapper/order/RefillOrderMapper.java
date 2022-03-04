package com.muskmelon.data.refill.center.mapper.order;

import com.muskmelon.data.refill.center.domain.RefillOrder;
import org.apache.ibatis.annotations.Insert;
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
public interface RefillOrderMapper {

    /**
     * 创建订单
     */
    @Insert("insert into refill_order (" +
            "order_no ," +
            "user_account_id ," +
            "business_account_id ," +
            "business_name ," +
            "amount ," +
            "title ," +
            "type ," +
            "status ," +
            "pay_type ," +
            "refill_comment ," +
            "refill_phone_number ," +
            "refill_data ," +
            "credit)" +
            "values (" +
            "#{orderNo} ," +
            "#{userAccountId} ," +
            "#{businessAccountId} ," +
            "#{businessName} ," +
            "#{amount} ," +
            "#{title} ," +
            "#{type} ," +
            "#{status} ," +
            "#{payType} ," +
            "#{refillComment} ," +
            "#{refillPhoneNumber} ," +
            "#{refillData} ," +
            "#{credit}" +
            ")")
    void insertOrder(RefillOrder refillOrder);


    @Select("select id,title,type,status,create_time,modified_time" +
            " from refill_order" +
            " where user_account_id = #{userAccountId}")
    @Results({
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "modified_time", property = "modifiedTime")
    })
    List<RefillOrder> queryAll(@Param("userAccountId") Long userAccountId);

    @Select("select * from refill_order where id = #{id}")
    @Results({
            @Result(column = "order_no", property = "orderNo"),
            @Result(column = "user_account_id", property = "userAccountId"),
            @Result(column = "business_account_id", property = "businessAccountId"),
            @Result(column = "business_name", property = "businessName"),
            @Result(column = "refill_comment", property = "refillComment"),
            @Result(column = "refill_phone_number", property = "refillPhoneNumber"),
            @Result(column = "refill_data", property = "refillData"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "modified_time", property = "modifiedTime")
    })
    RefillOrder queryById(@Param("id") Long id);
}
