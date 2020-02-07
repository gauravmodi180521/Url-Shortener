package com.gaurav.urlshortener.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.urlshortener.Service.UrlService;
import com.gaurav.urlshortener.models.UrlGenerator;

@RestController
@RequestMapping("/url")
public class UrlController {
	@Autowired
	private UrlService urlService;
	
	@PostMapping(value="/create")
	public String create(UrlGenerator url){
		String shortenUrl="Wrong Input";
		try {
			System.out.println("Inside user controller");
			shortenUrl = urlService.create(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shortenUrl;
	}
}
