package com.example.demo.config;

import com.lib.commons.config.TestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class Test {
    private static final Logger LOG
            = LoggerFactory.getLogger(Test.class);

    @Autowired
    private TestConfig testConfig;

    @PostConstruct
    public void postConstruct(){
        LOG.info("Value from dependency: {}", testConfig.getTeste());
    }
}