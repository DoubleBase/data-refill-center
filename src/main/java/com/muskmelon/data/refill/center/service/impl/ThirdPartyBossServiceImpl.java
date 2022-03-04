package com.muskmelon.data.refill.center.service.impl;

import com.muskmelon.data.refill.center.service.ThirdPartyBossService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author muskmelon
 * @since 1.0
 */
@Slf4j
@Service
public class ThirdPartyBossServiceImpl implements ThirdPartyBossService {

    @Override
    public void refillData(String phoneNumber, Integer data) {
        try {
            Thread.sleep(200);
            log.info("调用第三方接口向电话号码:{} 充值 {} MB 的流量", phoneNumber, data);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
