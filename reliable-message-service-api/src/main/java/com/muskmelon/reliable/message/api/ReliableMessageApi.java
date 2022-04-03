package com.muskmelon.reliable.message.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author muskmelon
 * @since 1.0
 */
@RequestMapping("/reliableMessage")
public interface ReliableMessageApi {

    @RequestMapping(value = "/prepare", method = RequestMethod.POST)
    Long prepareMessage(@RequestParam("message") String message);

    @RequestMapping(value = "/confirm", method = RequestMethod.PUT)
    Boolean confirmMessage(@RequestParam("messageId") Long messageId);

    @RequestMapping(value = "/remove", method = RequestMethod.PUT)
    Boolean removeMessage(@RequestParam("messageId") Long messageId);

    @RequestMapping(value = "/finish", method = RequestMethod.PUT)
    Boolean finishMessage(@RequestParam("messageId") Long messageId);
}
