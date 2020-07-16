package com.albot.contentorchestrationservice;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ContentOrchestrationServiceApplication {
	private static final Logger logger = LoggerFactory.getLogger(ContentOrchestrationServiceApplication.class);
	public static void main(String[] args) {
		logger.info("**********@Bootstrapping  Content Orchestration Service@*************");
		SpringApplication.run(ContentOrchestrationServiceApplication.class, args);
	}
}
