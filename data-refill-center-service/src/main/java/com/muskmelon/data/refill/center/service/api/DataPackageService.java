package com.muskmelon.data.refill.center.service.api;

import com.muskmelon.data.refill.center.datapackage.api.DataPackageApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("data-refill-center-datapackage")
public interface DataPackageService extends DataPackageApi {

}
