package com.hpe.demo.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/say")
	public String sayHi() {
		return "Welcome bhargav";
	}
}
