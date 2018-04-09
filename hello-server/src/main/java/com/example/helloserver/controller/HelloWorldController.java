package com.example.helloserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping(value="/demo")
public class HelloWorldController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping(value="/index")
	public String index() {
		ServiceInstance instance = discoveryClient.getLocalServiceInstance();
		System.out.println(JSONObject.toJSONString(instance));
        return "Hello World";
    }
	
	
	
	@RequestMapping(value="/hello")
	public String hello(String name) {
        return "hello" + name;
    }
}
