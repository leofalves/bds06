package com.devsuperior.movieflix.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devsuperior.movieflix.dto.UserDto;
import com.devsuperior.movieflix.services.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	UserService service;
	
	@GetMapping(value = "/profile")
	public ResponseEntity<UserDto> profileForCurrentUser(){
		UserDto dto = service.profileForCurrentUser();
		return ResponseEntity.ok().body(dto);
	}
}
