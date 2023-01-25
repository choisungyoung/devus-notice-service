package com.devus.noticeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NoticeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoticeServiceApplication.class, args);
	}

}
