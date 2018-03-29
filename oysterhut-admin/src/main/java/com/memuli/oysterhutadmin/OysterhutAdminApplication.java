package com.memuli.oysterhutadmin;

import com.memuli.oysterhutadmin.util.MessageSourceAccessor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

// 扫描指定包下面的mapper接口
@MapperScan("com.memuli.oysterhutadmin.dao")
@SpringBootApplication
public class OysterhutAdminApplication {
	@Value("${spring.messages.basename}")
	private String basename;
	@Value("${spring.messages.encoding}")
	private String encoding;

	public static void main(String[] args) {
		SpringApplication.run(OysterhutAdminApplication.class, args);
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