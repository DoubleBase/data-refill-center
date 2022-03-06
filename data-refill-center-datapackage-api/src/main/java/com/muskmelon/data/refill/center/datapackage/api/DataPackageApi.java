package com.muskmelon.data.refill.center.datapackage.api;


import com.muskmelon.data.refill.center.datapackage.domain.DataPackage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author muskmelon
 * @since 1.0
 */
@RequestMapping("/datapackage")
public interface DataPackageApi {

    /**
     * 查询流量包列表
     *
     * @return 流量包
     */
    @GetMapping("/selectList")
    List<DataPackage> selectList();


}
