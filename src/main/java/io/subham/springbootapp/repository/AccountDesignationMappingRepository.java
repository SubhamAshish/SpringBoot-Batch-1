package io.subham.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.subham.springbootapp.domain.AccountDesignationMapping;

public interface AccountDesignationMappingRepository extends JpaRepository<AccountDesignationMapping, Integer>{

}
