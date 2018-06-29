package com.rabbit.callback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit4")
public class CallBackController {
	@Autowired
	CallBackSender callBackSender;

	@PostMapping("/callback")
	public void callback() {
		callBackSender.send();
	}
}
