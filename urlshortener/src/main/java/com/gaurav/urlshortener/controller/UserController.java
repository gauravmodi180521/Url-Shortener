package com.gaurav.urlshortener.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.urlshortener.Service.UserService;
import com.gaurav.urlshortener.models.User;

@RestController
@RequestMapping("/urluser")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/save")
	public String saveUser(@RequestBody User user){
		try {
			System.out.println("Inside user controller");
			userService.save(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return("User Created successfully!!");
	}
}
