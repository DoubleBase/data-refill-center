package com.muskmelon.data.refill.center.service;

/**
 * @author muskmelon
 * @since 1.0
 */
public interface ThirdPartyBossService {

    /**
     * 充值流量
     * @param phoneNumber 手机号
     * @param data 流量
     */
    void refillData(String phoneNumber, Integer data) ;
}
