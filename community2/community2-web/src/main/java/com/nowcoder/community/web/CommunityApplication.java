package com.nowcoder.community.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

/**
 * @author zhangying
 */
@SpringBootApplication(scanBasePackages = {"com.nowcoder.community.web", "com.nowcoder.community.service", "com.nowcoder.community.common"})
@MapperScan("com.nowcoder.community.dao")
public class CommunityApplication {
	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
	}
}
