package io.subham.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.subham.springbootapp.service.ConfigurationService;

@RestController
public class ConfigurationController {

	@Autowired
	private ConfigurationService configurationService;
	
	@GetMapping("config")
	public ResponseEntity<String> config(){
		return configurationService.config();
	}
}
