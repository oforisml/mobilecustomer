package com.example.mobilecustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;

@SpringBootApplication
public class MobilecustomerApplication implements ApplicationRunner {
	public static final Logger logger = LogManager.getLogger(MobilecustomerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MobilecustomerApplication.class, args);

	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.debug("DEBUGGING: ");
		logger.info("INFORMATION: ");
		logger.warn("WARNING: ");
		logger.error("ERROR: ");
		logger.fatal("FATAL");

	}
}
