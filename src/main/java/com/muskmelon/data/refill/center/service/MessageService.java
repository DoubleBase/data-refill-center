package com.muskmelon.data.refill.center.service;

/**
 * @author muskmelon
 * @since 1.0
 */
public interface MessageService {

    /**
     * 发送短信
     * @param phoneNumber
     * @param msg 短信
     */
    void sendMessage(String phoneNumber, String msg);
}
