package cn.itcast.haoke.dubbo.api.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Young
 * @date 2019/12/16 11:35
 * @description：阿里云OSS上传配置
 */
@Configuration
@PropertySource(value = {"classpath:application-aliyun.yml"})
@ConfigurationProperties(prefix = "aliyun")
@Data
public class AliyunConfig {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private String endpoint;
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String urlPrefix;

    @Bean
    public OSS ossClient(){
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

}
