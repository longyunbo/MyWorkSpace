package com.example.ribbonconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/consumer")
public class HelloWorldController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value="/index",method = RequestMethod.GET)
	public String index() {
		System.out.println("----------->"+restTemplate.getForEntity("http://hello-server/demo/index", String.class).getBody());
        return restTemplate.getForEntity("http://hello-server/demo/index", String.class).getBody();
    }
}
