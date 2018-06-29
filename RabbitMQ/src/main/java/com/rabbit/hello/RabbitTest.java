package com.rabbit.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.user.UserSender;

@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

	@Autowired
	private HelloSender1 helloSender1;
	@Autowired
	private HelloSender2 helloSender2;
	@Autowired
	private UserSender userSender;

	@PostMapping("/hello")
	public void hello() {
		helloSender1.send("hello");
	}

	@PostMapping("/oneToMany")
	public void oneToMany() {
		for (int i = 0; i < 10; i++) {
			helloSender1.send("hellomsg:" + i);
		}

	}

	@PostMapping("/manyToMany")
	public void manyToMany() {
		for (int i = 0; i < 10; i++) {
			helloSender1.send("hellomsg:" + i);
			helloSender2.send("hellomsg:" + i);
		}

	}

	@PostMapping("/userTest")
	public void userTest() {
		userSender.send();
	}
}