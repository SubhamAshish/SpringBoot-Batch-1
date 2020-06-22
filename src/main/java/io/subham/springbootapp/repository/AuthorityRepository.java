package io.subham.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.subham.springbootapp.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer>{

}
