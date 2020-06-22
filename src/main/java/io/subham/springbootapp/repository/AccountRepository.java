package io.subham.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.subham.springbootapp.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

	Account findById(Integer id);

}
