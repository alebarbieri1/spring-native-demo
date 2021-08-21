package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.nativex.hint.*;

@SpringBootApplication
@NativeHint(types = {
		@TypeHint(types = {RedisKeyValueAdapter.EnableKeyspaceEvents.class})
})
public class SpringNativeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNativeDemoApplication.class, args);
	}
}