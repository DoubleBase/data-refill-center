package com.muskmelon.reliable.schedule;

import com.muskmelon.reliable.constant.MessageStatus;
import com.muskmelon.reliable.mapper.MessageMapper;
import com.muskmelon.reliable.message.domain.Message;
import com.muskmelon.reliable.rabbitmq.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author muskmelon
 * @since 1.0
 */
@Component
public class ScanSendMessageTask {

    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private MessageProducer messageProducer;

    @Scheduled(fixedRate = 10 * 60 * 1000)
    public void execute() {
        List<Message> messages = messageMapper.findByStatus(MessageStatus.CONFIRMED);

        for (Message message : messages) {
            try {
                checkPreparedMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Transactional(rollbackFor = Exception.class)
    void checkPreparedMessage(Message message) {
        long confirmTime = message.getConfirmedTime().getTime();
        long currentTime = System.currentTimeMillis();

        if (currentTime - confirmTime > 10 * 60 * 1000) {
            messageProducer.send(message.getContent());
        }
    }


}



