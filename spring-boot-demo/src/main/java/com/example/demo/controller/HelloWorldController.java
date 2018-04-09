package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/demo")
public class HelloWorldController {
	
	@Value("${sourcename}")
	private String sourceName;
	
	@RequestMapping(value="/index")
	public String index() {
		System.out.println(sourceName);
        return "Hello World";
    }
}
