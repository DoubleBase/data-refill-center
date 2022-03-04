package com.muskmelon.data.refill.center.mapper.datapackage;

import com.muskmelon.data.refill.center.domain.DataPackage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author muskmelon
 * @since 1.0
 */
@Mapper
public interface DataPackageMapper {

    @Select("select id,price,data,type,comment,created_time,modified_time from data_package")
    @Results({
            @Result(column = "created_time", property = "createdTime"),
            @Result(column = "modified_time", property = "modifiedTime")
    })
    List<DataPackage> selectList();

}
