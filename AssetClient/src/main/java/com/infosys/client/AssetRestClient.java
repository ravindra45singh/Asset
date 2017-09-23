package com.infosys.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

@Component
public class AssetRestClient {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AssetRestClient.class);

	
	final String uri = "http://localhost:9004/app/test/getCapital";
	
	 private HttpEntity<String> getHttpEntity() {
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        return new HttpEntity<String>("Hi", headers );

	    }
	
	@Scheduled(fixedRate = 6000)
	public void invokeRestServer(){
		LOGGER.info("0; invokeRestServer Called");
		try {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(uri + "/australia", HttpMethod.GET, getHttpEntity(), String.class);
	    LOGGER.info("0;Response from server is: {}",response.getBody());
		}catch ( HttpClientErrorException ex ) {
			LOGGER.info("0;Exception from server is: {}",ex.getMessage());
		}
	}

}
