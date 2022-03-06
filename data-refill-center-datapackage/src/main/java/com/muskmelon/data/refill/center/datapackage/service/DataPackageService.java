package com.muskmelon.data.refill.center.datapackage.service;

import com.muskmelon.data.refill.center.datapackage.api.DataPackageApi;
import com.muskmelon.data.refill.center.datapackage.domain.DataPackage;
import com.muskmelon.data.refill.center.datapackage.mapper.DataPackageMapper;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author muskmelon
 * @since 1.0
 */
@RestController
public class DataPackageService implements DataPackageApi {

    @Resource
    private DataPackageMapper dataPackageMapper;

    @Override
    public List<DataPackage> selectList() {
        return dataPackageMapper.selectList();
    }

}
