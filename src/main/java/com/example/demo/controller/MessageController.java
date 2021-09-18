package com.example.demo.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.example.demo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.payloadoffloading.Util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private AmazonSQS sqsClient;
    @Autowired
    private AmazonS3 s3Client;
    @Value("${aws.s3.bucketName}")
    private String bucketName;
    @Value("${aws.sqs.queueName}")
    private String queueName;
    @Value("${aws.sqs.endpoint}")
    private String sqsEndpoint;

    @PostMapping
    public ResponseEntity<String> sendMessage() {
        String queueUrl = sqsEndpoint + queueName;
        String id = UUID.randomUUID().toString();
        String message = "message " + id;
        storeMessageInS3(message, id);
        SendMessageRequest messageRequest = new SendMessageRequest(queueUrl, message);
        addMessageAttribute(messageRequest, "teste", "123");

        sqsClient.sendMessage(messageRequest);

        return ResponseEntity.ok("success");
    }

    private void storeMessageInS3(String message, String id){
        InputStream inputStream = new ByteArrayInputStream(message.getBytes(StandardCharsets.UTF_8));
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(Util.getStringSizeInBytes(message));

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, id, inputStream, objectMetadata);
        s3Client.putObject(putObjectRequest);
    }

    private void addMessageAttribute(SendMessageRequest sendMessageRequest, String name, String value){
        MessageAttributeValue messageAttributeValue = new MessageAttributeValue();
        messageAttributeValue.setDataType("String");
        messageAttributeValue.setStringValue(value);
        sendMessageRequest.addMessageAttributesEntry(name, messageAttributeValue);
    }
}