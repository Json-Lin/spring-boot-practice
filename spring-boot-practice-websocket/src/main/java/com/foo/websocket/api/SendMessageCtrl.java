package com.foo.websocket.api;

import com.foo.websocket.handler.MyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2019/7/10
 */
@RestController
@Slf4j
public class SendMessageCtrl {

    @Autowired
    private MyHandler myHandler;

    @RequestMapping("/send")
    public void sendMessage(String message) {
        myHandler.sendMessage(new TextMessage(message));
        log.info("send message :" + message);
    }
}
