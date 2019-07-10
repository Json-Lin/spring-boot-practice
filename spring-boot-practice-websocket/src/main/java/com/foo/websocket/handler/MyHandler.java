package com.foo.websocket.handler;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2019/7/10
 */
@Slf4j
@Component
public class MyHandler extends TextWebSocketHandler {

    private Map<String, WebSocketSession> sessionMap = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionMap.put(session.getId(), session);
        log.info(session.getId() + " established a connection");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionMap.remove(session.getId());
        log.info(session.getId() + " closed a connection");
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        log.info(String.format("receive a message from[%s] message:%s", session.getId(), message.toString()));
    }

    public void sendMessage(TextMessage message) {
        List<String> closedSessions = Lists.newArrayList();
        for (Map.Entry<String, WebSocketSession> sessionEntry : sessionMap.entrySet()) {
            WebSocketSession session = sessionEntry.getValue();
            if (null != session && session.isOpen()) {
                try {
                    session.sendMessage(message);
                } catch (IOException e) {
                    log.error("websocket send message error, " + e.getMessage(), e);
                }
            } else {
                closedSessions.add(sessionEntry.getKey());
            }
        }
        if (!CollectionUtils.isEmpty(closedSessions)) {
            for (String sessionId : closedSessions) {
                sessionMap.remove(sessionId);
            }
        }
    }
}
