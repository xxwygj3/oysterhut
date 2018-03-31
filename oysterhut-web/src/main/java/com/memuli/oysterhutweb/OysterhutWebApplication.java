package com.memuli.oysterhutweb;

import com.memuli.oysterhutweb.util.MessageSourceAccessor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 扫描指定包下面的mapper接口
@MapperScan("com.memuli.oysterhutweb.dao")
@EnableTransactionManagement// 启注解事务管理
@SpringBootApplication
public class OysterhutWebApplication {
	@Value("${spring.messages.basename}")
	private String basename;
	@Value("${spring.messages.encoding}")
	private String encoding;

	public static void main(String[] args) {
		SpringApplication.run(OysterhutWebApplication.class, args);
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setDefaultEncoding(encoding);
		messageSource.setBasename(basename);
		return messageSource;
	}

	@Bean
	public MessageSourceAccessor initMessageSourceAccessor(){
		return new MessageSourceAccessor(messageSource());
	}
}
