package cn.pengyinzhuo.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("cn.pengyinzhuo.shop.dao")
public class MemberDaoMain {

	public static void main(String[] args) {
		SpringApplication.run(MemberDaoMain.class, args);
	}
}
