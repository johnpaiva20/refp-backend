package com.tostringtech.refp.application.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AWSConfig {
	
	@Value("${awsinfo.accesskey}")
	private String accessKey;

	@Value("${awsinfo.secretKey}")
	private String secretKey;

	@Value("${awsinfo.region}")
	private String region;
	
	@Bean
	public AmazonS3 s3client(){
		BasicAWSCredentials awsCred = new BasicAWSCredentials(accessKey, secretKey);
		AmazonS3 s3client = AmazonS3ClientBuilder
							.standard()
							.withRegion(Regions.fromName(region))
							.withCredentials(new AWSStaticCredentialsProvider(awsCred))
							.build();
		return s3client;
	}

}
