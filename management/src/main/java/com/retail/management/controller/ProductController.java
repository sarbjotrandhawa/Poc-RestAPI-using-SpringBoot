package com.retail.management.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@RequestMapping("/hello")
	public String hello() {
		return "hi";
	}

}
