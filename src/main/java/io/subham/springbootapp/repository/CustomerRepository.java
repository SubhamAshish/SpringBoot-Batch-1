package io.subham.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.subham.springbootapp.domain.Customer;

@Repository
//@RepositoryDefinition
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findById(Integer id);

	@Modifying
	@Query(" update Customer c set c.name=:name WHERE id=:id")
	void updateCustomer(@Param("id") Integer id, @Param("name") String fullName);

}
