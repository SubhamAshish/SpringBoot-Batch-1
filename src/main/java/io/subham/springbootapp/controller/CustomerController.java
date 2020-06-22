package io.subham.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.subham.springbootapp.dto.CustomerDTO;
import io.subham.springbootapp.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	@Qualifier("cus1")
	private CustomerService customerService;

	@PostMapping("/createCust")
	public String createCustomer(@RequestBody CustomerDTO CustomerDTO) {
		return customerService.createCustomer(CustomerDTO);
	}

	// GET
	@GetMapping("getCus/{id}")
	public CustomerDTO getCustomer(@PathVariable("id") Integer id) {
		return customerService.getCustomer(id);
	}

	// update
	@PutMapping("updateCustomer")
	public String updateCustomer(@RequestBody CustomerDTO customerDTO) {

		return customerService.updateCustomer(customerDTO);
	}
	
	

}
