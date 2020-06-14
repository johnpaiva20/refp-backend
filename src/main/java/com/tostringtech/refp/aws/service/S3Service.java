package com.tostringtech.refp.aws.service;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.tostringtech.refp.application.exceptions.StandardException;

@Service
public class S3Service {
	
	final Logger logger = LoggerFactory.getLogger(S3Service.class);
	
	@Autowired
	private AmazonS3 s3client;
	
	@Value("${awsinfo.bucketName}")
	private String bucketName;
	
	public void uploadFile(String localFilePath, String imageName) {
		try {
			logger.info("INICIANDO UPLOAD");
			File file = new File(localFilePath);
			s3client.putObject(new PutObjectRequest(bucketName, imageName + ".jpg", file));
			logger.info("FINALIZANDO UPLOAD");
		} catch (AmazonServiceException e) {
			logger.info("AmazonServiceException" + e.getErrorMessage());
			throw new StandardException("Erro ao tentar salvar arquivo de imagem." + e.getErrorCode());
		} catch (AmazonClientException e) {
			logger.info("AmazonClientException" + e.getMessage());
			throw new StandardException("Erro ao tentar salvar arquivo de imagem.");
		}
	}
}
