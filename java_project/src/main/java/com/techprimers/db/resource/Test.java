package com.techprimers.db.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/test/")
public class Test {

	
	@GetMapping(value = "/t")
	public Double stats() {
		return 2.2;
	}
}
