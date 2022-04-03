package com.muskmelon.reliable.schedule;

import com.muskmelon.data.refill.center.service.api.DataRefillCenterApi;
import com.muskmelon.reliable.constant.MessageStatus;
import com.muskmelon.reliable.mapper.MessageMapper;
import com.muskmelon.reliable.message.domain.Message;
import com.muskmelon.reliable.rabbitmq.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author muskmelon
 * @since 1.0
 */
@Component
public class ScanPreparedMessageTask {

    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private DataRefillCenterApi dataRefillCenterService;
    @Autowired
    private MessageProducer messageProducer;

    @Scheduled(fixedRate = 10 * 60 * 1000)
    public void execute() {
        List<Message> messages = messageMapper.findByStatus(MessageStatus.PREPARED);

        for(Message message : messages) {
            try {
                checkPreparedMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Transactional(rollbackFor = Exception.class)
    void checkPreparedMessage(Message message) {
        long createdTime = message.getCreatedTime().getTime();
        long currentTime = System.currentTimeMillis();

        if(currentTime - createdTime > 10 * 60 * 1000) {
            // 回调查询状态
            Boolean operationStatus = dataRefillCenterService.queryOperationStatus(
                    message.getContent());

            if(operationStatus) {
                message.setStatus(MessageStatus.CONFIRMED);
                message.setConfirmedTime(new Date());

                messageMapper.confirm(message);
                messageProducer.send(message.getContent());
            } else {
                message.setStatus(MessageStatus.REMOVED);
                message.setRemovedTime(new Date());

                messageMapper.remove(message);
            }
        }
    }


}



