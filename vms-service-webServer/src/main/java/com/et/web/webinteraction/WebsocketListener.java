package com.et.web.webinteraction;


import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * @Description：websocket拦截器，握手前后的两个切面
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/9/7 16:34
 */
public class WebsocketListener implements HandshakeInterceptor{
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        if (serverHttpRequest instanceof ServletServerHttpRequest) {
           System.out.println("vid:"+((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getParameter("vid"));
         //  map.put("vid",);
//            // 标记用户
//            User user = (User) session.getAttribute("user");
//            if(user!=null){
//                map.put("uid", user.getUserId());//为服务器创建WebSocketSession做准备
//                System.out.println("用户id："+user.getUserId()+" 被加入");
//            }else{
//                System.out.println("user为空");
//                return false;
//            }
        }
        return true;
    }

    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }
}
