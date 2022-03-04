package com.muskmelon.data.refill.center.service;

import com.muskmelon.data.refill.center.domain.DataPackage;

import java.util.List;

/**
 * @author muskmelon
 * @since 1.0
 */
public interface DataPackageService {

    /**
     * 查询流量包列表
     *
     * @return 流量包
     */
    List<DataPackage> selectList();


}
