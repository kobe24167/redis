package com.rabbit.fanout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit3")
public class FanoutController {
	@Autowired
	FanoutSender fanoutSender;

	@PostMapping("/fanoutTest")
	public void fanoutTest() {
		fanoutSender.send();
	}
}
