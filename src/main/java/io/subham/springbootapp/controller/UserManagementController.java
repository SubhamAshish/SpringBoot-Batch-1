package io.subham.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.subham.springbootapp.dto.AccountDTO;
import io.subham.springbootapp.dto.AccountResponseDTO;
import io.subham.springbootapp.service.UserManagementService;

@Controller
public class UserManagementController {

	@Autowired
	private UserManagementService userManagementService;

	@PostMapping("createUser")
	@ResponseBody
	private ResponseEntity<String> createAccount(@RequestBody AccountDTO accountDTO) {
		return userManagementService.createAccount(accountDTO);
	}
	
	@GetMapping("getAccount")
	@ResponseBody
	public AccountResponseDTO getAccountDetails(@RequestParam("id") Integer id) {
		return userManagementService.getAccountDetails(id);
	}
}
