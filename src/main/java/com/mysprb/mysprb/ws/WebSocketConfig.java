package com.mysprb.mysprb.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Created by Administrator on 2019/1/4.
 */
/**
 * @Configuration指名当前类为配置类，代替之前的spring配置文件
 */
@Configuration
public class WebSocketConfig {
    //将方法的返回值添加到容器中：容器中这个组件的默认id为方法名
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
