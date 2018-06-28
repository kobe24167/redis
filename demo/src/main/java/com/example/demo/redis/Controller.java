package com.example.demo.redis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/redis")
public class Controller {

	@RequestMapping(method = RequestMethod.POST)
	public String getRedisValue (@RequestParam(value = "key") String key) {
		Jedis jedis = new Jedis("116.196.97.97");
		String value = jedis.get(key);
		return value;
	}
	
}
