package com.example.feignconsumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hello-server")
public interface HelloService {
	
	@RequestMapping(value = "/demo/index")
	String index();
	
	@RequestMapping(value = "/demo/hello")
	String hello(@RequestParam("name") String name);
}
