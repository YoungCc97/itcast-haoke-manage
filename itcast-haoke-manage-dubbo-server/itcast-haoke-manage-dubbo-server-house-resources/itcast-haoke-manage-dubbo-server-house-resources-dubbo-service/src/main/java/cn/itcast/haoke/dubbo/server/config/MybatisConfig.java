package cn.itcast.haoke.dubbo.server.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Young
 */
@MapperScan("cn.itcast.haoke.dubbo.server.mapper")
@Configuration
public class MybatisConfig {

}