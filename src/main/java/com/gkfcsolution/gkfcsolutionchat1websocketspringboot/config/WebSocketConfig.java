package com.gkfcsolution.gkfcsolutionchat1websocketspringboot.config;

import com.gkfcsolution.gkfcsolutionchat1websocketspringboot.handlers.SocketConnectionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created on 2025 at 21:59
 * File: null.java
 * Project: gkfcsolution-chat1-websocket-springboot
 *
 * @author Frank GUEKENG
 * @date 06/11/2025
 * @time 21:59
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new SocketConnectionHandler(), "/hello")
                .setAllowedOrigins("*");
    }
}
