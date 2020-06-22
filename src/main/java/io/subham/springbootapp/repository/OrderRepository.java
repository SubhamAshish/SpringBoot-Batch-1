package io.subham.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.subham.springbootapp.domain.CustomerOrder;

public interface OrderRepository extends JpaRepository<CustomerOrder, Integer>{

	CustomerOrder findByCustomerId(Integer id);

}
