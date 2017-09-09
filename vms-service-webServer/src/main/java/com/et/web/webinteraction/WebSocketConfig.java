package com.et.web.webinteraction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Description：
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/9/8 8:58
 */

@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{

    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(getWebsocketHandler(),"/webSocketServer").addInterceptors(new WebsocketListener());
    }
    @Bean
    public WebsocketHandlerImpl getWebsocketHandler(){
        return new WebsocketHandlerImpl();
    }
//    @Bean
//    public WebSocketContainerFactoryBean getWebSocketContainer(){
//
//    }
}
