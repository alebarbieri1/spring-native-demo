package com.example.demo.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {
    @Value("${aws.region}")
    private String AWS_REGION;
    @Value("${aws.s3.endpoint}")
    private String AWS_SQS_ENDPOINT;

    @Bean
    public AmazonS3 createAmazonS3Client(){
        final AwsClientBuilder.EndpointConfiguration endpoint =
                new AwsClientBuilder.EndpointConfiguration(AWS_SQS_ENDPOINT, AWS_REGION);
        return AmazonS3ClientBuilder.
                standard().
                withEndpointConfiguration(endpoint).
                withPathStyleAccessEnabled(true).
                build();
    }
}
