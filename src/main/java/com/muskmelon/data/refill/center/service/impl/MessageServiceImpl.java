package com.muskmelon.data.refill.center.service.impl;

import com.muskmelon.data.refill.center.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author muskmelon
 * @since 1.0
 */
@Slf4j
@Service
public class MessageServiceImpl implements MessageService {

    @Override
    public void sendMessage(String phoneNumber, String msg) {
        log.info("向手机号:{}发送短信，短信内容:{}", phoneNumber, msg);
    }
}
