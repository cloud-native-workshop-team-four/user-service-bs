package com.lti.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.User;
import com.lti.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserService service;
	
//	http://localhost:8003/add_user_detail
	@PostMapping(value = "/add_user_detail" , consumes = "application/json")
	public String addUserDetail(@RequestBody User user) {
		service.saveUser(user);
		return "User Details added successfully";
	}
	
	@GetMapping(value="/validate/{email}" , produces = "application/json")
	public User findByEmail(@PathVariable String email) {
		User user = service.searchByEmail(email);
		return user;
	}
	
//	http://localhost:8003/change_exam_score/101/70
	@GetMapping(value="/change_exam_score/{userId}/{score}", produces ="application/json")
	public String changeScore(@PathVariable int userId, @PathVariable double score) {
		service.updateScore(userId,score);
		return "Score updated uccessfully to " + score + "%";
	}
}
