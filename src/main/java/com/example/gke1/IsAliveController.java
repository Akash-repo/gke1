package com.example.gke1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IsAliveController {

	@GetMapping("/is-alive")
	public String isAlive() {
		return "OK";
	}

}
