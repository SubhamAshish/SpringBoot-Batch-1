package io.subham.springbootapp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.subham.springbootapp.dto.CustomerDTO;

@Service("cust2")
public class CustomerServcImpl2 implements CustomerService {

	@Override
	public String createCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO getCustomer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		return null;
	}


}
