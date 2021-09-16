package com.example.demo;

import com.lib.commons.config.TestConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
class SpringNativeDemoApplicationTests {

	@BeforeAll
	static void setCredentials(){
		System.setProperty("aws.accessKeyId", "<ACCESS_KEY>");
		System.setProperty("aws.secretKey", "<SECRET_KEY>");
	}

	@Test
	void contextLoads() {
	}

}
