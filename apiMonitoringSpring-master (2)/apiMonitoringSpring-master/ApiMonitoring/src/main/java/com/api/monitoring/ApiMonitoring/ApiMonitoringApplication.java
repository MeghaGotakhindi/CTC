package com.api.monitoring.ApiMonitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication

public class ApiMonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiMonitoringApplication.class, args);
	}

}
