package com.muskmelon.data.refill.center.service.impl;

import com.muskmelon.data.refill.center.domain.DataPackage;
import com.muskmelon.data.refill.center.mapper.datapackage.DataPackageMapper;
import com.muskmelon.data.refill.center.service.DataPackageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author muskmelon
 * @since 1.0
 */
@Service
public class DataPackageServiceImpl implements DataPackageService {

    @Resource
    private DataPackageMapper dataPackageMapper;

    @Override
    public List<DataPackage> selectList() {
        return dataPackageMapper.selectList();
    }


}
