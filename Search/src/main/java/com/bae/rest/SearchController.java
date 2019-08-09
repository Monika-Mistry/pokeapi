package com.bae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SearchController {

	@Value("${url.pokeapi}")
	private String pokeApiURL;

	private RestTemplate restTemplate;

	public SearchController(@Autowired RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable("id") String id) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		return restTemplate.exchange(pokeApiURL + id, HttpMethod.GET, entity, Object.class);
	}

	@GetMapping("/{name}")
	public ResponseEntity<Object> findByName(@PathVariable("name") String name) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

		
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		return restTemplate.exchange(pokeApiURL + name, HttpMethod.GET, entity, Object.class);

	}

}
