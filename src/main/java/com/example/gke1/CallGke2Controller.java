package com.example.gke1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class CallGke2Controller {

	private final RestClient restClient;

	public CallGke2Controller(@Value("${gke2.base-url}") String gke2BaseUrl) {
		this.restClient = RestClient.create(gke2BaseUrl);
	}

	@GetMapping("/call-gke2")
	public String callGke2() {
		return restClient.get().uri("/metadata").retrieve().body(String.class);
	}

}
