package com.einwin.mdm.logging.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/**
 * 日志微服务启动类
 * @author LUPE004
 *
 */
@SpringBootApplication //定义spring boot应用
@EnableDiscoveryClient //开启服务注册
public class BaseDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(BaseDemoApplication.class, args);
	}
}
