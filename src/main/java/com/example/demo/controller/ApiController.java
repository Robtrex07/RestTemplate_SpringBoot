package com.example.demo.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.PageDetail;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ApiController {
	@Autowired
	private RestTemplate restTemplate;
	private String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=1";

	@GetMapping("/movies")
	public PageDetail getMovies() {
		/*
		 * Catalogue moviesCata = restTemplate.getForObject(url, Catalogue.class);
		 * System.out.println(moviesCata.toString()); return moviesCata.getData();
		 */
		ResponseEntity<PageDetail> result = restTemplate.exchange(url, HttpMethod.GET, null, PageDetail.class);
		System.out.println(result.getStatusCode());
		return result.getBody();

	}

	@GetMapping("/hello")
	public String hello() {
		return "hellossa";
	}
}