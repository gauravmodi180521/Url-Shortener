package com.gaurav.urlshortener.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Date;

import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaurav.urlshortener.models.UrlGenerator;
import com.gaurav.urlshortener.models.UrlHit;

@Service
public class UrlService {
	
	@Autowired
	private RestHighLevelClient client;
	
	public String create(UrlGenerator url) throws IOException {
		System.out.println("Inside url service");
		String hash = getMd5(url.getOriginalUrl());
		
		UrlHit urlHit = new UrlHit().withoriginalUrl(url.getOriginalUrl())
				.withuserId(url.getUserId())
				.withcreationDate(new Date())
				.withshortenUrl(hash);
		
		IndexRequest request = new IndexRequest("url").id(url.getUserId())
				.source(new ObjectMapper().writeValueAsString(urlHit), XContentType.JSON)
				.opType(DocWriteRequest.OpType.CREATE);
		
		IndexResponse response = client.index(request, RequestOptions.DEFAULT);

		System.out.println(response.getId());
		return hash;
	}
	public String getMd5(String input) 
    { 
		try { 
			MessageDigest md = MessageDigest.getInstance("MD5");
	        byte[] hashInBytes = md.digest(input.getBytes(StandardCharsets.UTF_8));
	        StringBuilder sb = new StringBuilder();
	        for (byte b : hashInBytes) {
	            sb.append(String.format("%02x", b));
	        }
			return sb.toString(); 
		}  
		catch (Exception e) { 
			throw new RuntimeException(e); 
		} 
    } 
}
