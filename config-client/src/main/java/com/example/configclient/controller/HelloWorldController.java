package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/demo")
public class HelloWorldController {
	
	@Value("${from}")
	private String from;
	
	@RequestMapping(value="/from")
	public String hello() {
        return "hello" + this.from;
    }
}
