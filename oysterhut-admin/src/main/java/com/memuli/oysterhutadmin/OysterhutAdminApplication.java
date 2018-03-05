package com.memuli.oysterhutadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

// 扫描指定包下面的mapper接口
@MapperScan("com.memuli.oysterhutadmin.dao")
@SpringBootApplication
public class OysterhutAdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(OysterhutAdminApplication.class, args);
	}
}