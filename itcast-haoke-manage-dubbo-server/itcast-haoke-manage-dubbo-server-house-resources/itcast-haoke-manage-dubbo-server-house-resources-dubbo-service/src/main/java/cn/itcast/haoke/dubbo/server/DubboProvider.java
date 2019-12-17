package cn.itcast.haoke.dubbo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author Young
 * @date 2019/12/16 9:30
 * @description：启动类
 */
@SpringBootApplication
public class DubboProvider {

    public static void main(String[] args){
        //非web应用
        new SpringApplicationBuilder(DubboProvider.class).web(WebApplicationType.NONE).run(args);
    }
}
