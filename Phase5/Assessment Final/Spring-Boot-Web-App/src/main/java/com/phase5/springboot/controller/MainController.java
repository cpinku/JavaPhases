package com.phase5.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	 @RequestMapping("/")
	  public String index() {
	    return "Welcome To Spring Boot CI-CD deployment";
	  }
}
