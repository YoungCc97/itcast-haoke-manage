package cn.itcast.haoke.dubbo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author Young
 * @date 2019/12/30 11:37
 * @description：轮播广告启动类
 */
@SpringBootApplication
public class AdDubboProvider {
    public static void main(String[] args){
        new SpringApplicationBuilder(AdDubboProvider.class).web(WebApplicationType.NONE).run(args);
    }
}
