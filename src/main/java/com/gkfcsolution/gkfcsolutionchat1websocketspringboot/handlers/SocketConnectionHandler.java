package com.gkfcsolution.gkfcsolutionchat1websocketspringboot.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on 2025 at 21:49
 * File: null.java
 * Project: gkfcsolution-chat1-websocket-springboot
 *
 * @author Frank GUEKENG
 * @date 06/11/2025
 * @time 21:49
 */
@Slf4j
public class SocketConnectionHandler extends TextWebSocketHandler {
    List<WebSocketSession> webSocketSessions = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        log.info("Session with ID {} Connected", session.getId());
        webSocketSessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        log.info("Session with ID {} Disconnected", session.getId());
        webSocketSessions.remove(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        super.handleMessage(session, message);
        for (WebSocketSession webSocketSession: webSocketSessions){
            if (session == webSocketSession){
                continue;
            }
            webSocketSession.sendMessage(message);
        }
    }
}
