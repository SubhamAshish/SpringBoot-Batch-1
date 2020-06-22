package io.subham.springbootapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.subham.springbootapp.domain.Customer;
import io.subham.springbootapp.domain.CustomerOrder;
import io.subham.springbootapp.dto.CustomerDTO;
import io.subham.springbootapp.exception.CustomerNotFoundException;
import io.subham.springbootapp.repository.CustomerRepository;
import io.subham.springbootapp.repository.OrderRepository;

@Service("cus1")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository cusRepo;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private Environment env;
	
//	@Autowired
//	private ConfigurableEnvironment confEnv;
	
	@Override
	@Transactional
	public String createCustomer(CustomerDTO customerDTO) {

		Customer customer = new Customer();

		customer.setAddress(customerDTO.getAddress());
		customer.setName(customerDTO.getFullName());

		CustomerOrder order = new CustomerOrder();
		order.setOrderName(customerDTO.getFullName());

		// insert query
		Customer cusSave = cusRepo.save(customer);

//		if (cus != null)
//			throw new RuntimeException("custom exception");

		order.setCustomer(cusSave);

		orderRepository.save(order);

//		customer.create.success
		return "success";
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "formData", key = "#id")
	public CustomerDTO getCustomer(Integer id) {

//		if(id==null)
//			id=5;

		try {

			Customer cus = cusRepo.findById(id);

			if (cus == null)
				throw new CustomerNotFoundException("customer not found");

			CustomerDTO customerDto = new CustomerDTO();

			customerDto.setAddress(cus.getAddress());
			customerDto.setFullName(cus.getName());

			System.out.println("====================================================");
			System.out.println(cus.getCustomerOrder().getOrderName());
			
			return customerDto;

		} catch (DataAccessException e) {
			throw new RuntimeException(e);
		} catch (CustomerNotFoundException e) {
			throw new CustomerNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	// leve1-1
	// leavel-2

	@Transactional
	@Override
	@CachePut(value = "formData", key = "#customerDTO.id")
	public String updateCustomer(CustomerDTO customerDTO) {

//		customerRepository.updateCustomer(customerDTO.getId(), customerDTO.getFullName());

		Customer cus = cusRepo.findById(customerDTO.getId());

		Optional<Customer> customer = Optional.ofNullable(cus);

		if (customer.isPresent()) {

			customer.get().setName(customerDTO.getFullName());

//			customerRepository.save(customer.get());
			return "Successfully updated";
		} else {
			throw new CustomerNotFoundException(env.getProperty("customer.not.found.error"));
		}

	}

	// Eager Loading

	// Lazy Loading

}
