package com.example.demo.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SqsConfig {
    @Value("${aws.region}")
    private String AWS_REGION;
    @Value("${aws.sqs.endpoint}")
    private String AWS_SQS_ENDPOINT;

    @Bean
    public AmazonSQS createAmazonSQSClient(){
        final AwsClientBuilder.EndpointConfiguration endpoint =
                new AwsClientBuilder.EndpointConfiguration(AWS_SQS_ENDPOINT, AWS_REGION);
        return AmazonSQSClientBuilder
                .standard()
                .withEndpointConfiguration(endpoint)
                .build();
    }

}
