package com.rabbit.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit2")
public class TopicController {
	@Autowired
	TopicSender topicSender;

	@PostMapping("/topicTest")
	public void topicTest() {
		topicSender.send();
	}
}
