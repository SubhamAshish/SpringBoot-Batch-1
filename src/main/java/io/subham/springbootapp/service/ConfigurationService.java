package io.subham.springbootapp.service;

import org.springframework.http.ResponseEntity;

public interface ConfigurationService {

	ResponseEntity<String> config();

}
