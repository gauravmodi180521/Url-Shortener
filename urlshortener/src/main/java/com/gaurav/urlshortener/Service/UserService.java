package com.gaurav.urlshortener.Service;

import java.io.IOException;

import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaurav.urlshortener.models.User;

@Service
public class UserService {
	@Autowired
	private RestHighLevelClient client;
	
	
	public void save(User user) throws IOException {
		System.out.println("Inside user service");
		IndexRequest request = new IndexRequest("urluser").id(user.getId())
				.source(new ObjectMapper().writeValueAsString(user), XContentType.JSON)
				.opType(DocWriteRequest.OpType.CREATE);

		System.out.println(user.getName());

		IndexResponse response = client.index(request, RequestOptions.DEFAULT);
		System.out.println(response.getId());
	}
}

