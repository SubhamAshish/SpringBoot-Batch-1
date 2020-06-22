package io.subham.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.subham.springbootapp.domain.Designation;

public interface DesignationRepository extends JpaRepository<Designation, Integer>{

	Designation findById(Integer designationId);

}
