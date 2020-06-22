package io.subham.springbootapp.service;

import org.springframework.http.ResponseEntity;

import io.subham.springbootapp.dto.AccountDTO;
import io.subham.springbootapp.dto.AccountResponseDTO;

public interface UserManagementService {

	ResponseEntity<String> createAccount(AccountDTO accountDTO);

	AccountResponseDTO getAccountDetails(Integer id);

}
