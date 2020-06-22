package io.subham.springbootapp.service;

import io.subham.springbootapp.dto.CustomerDTO;

public interface CustomerService {

	String createCustomer(CustomerDTO customerDTO);

	CustomerDTO getCustomer(Integer id);

	String updateCustomer(CustomerDTO customerDTO);

}
