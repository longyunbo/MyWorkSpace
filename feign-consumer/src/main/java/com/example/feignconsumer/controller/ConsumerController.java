package com.example.feignconsumer.controller;

import com.example.feignconsumer.service.HelloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/consumer")
public class ConsumerController {
	
	@Autowired
	HelloService helloService;
	
	@RequestMapping(value="/feign-consumer",method = RequestMethod.GET)
	public String helloConsumer(){
		return helloService.index();
	}
	
	@RequestMapping(value="/hello",method = RequestMethod.GET)
	public String hello(){
		return helloService.hello("Jack");
	}
}
