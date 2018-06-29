package com.rabbit.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.user.UserSender;

@RestController
@RequestMapping("/rabbit1")
public class UserController {
	@Autowired
	private UserSender userSender;

	@PostMapping("/userTest")
	public void userTest() {
		userSender.send();
	}
}