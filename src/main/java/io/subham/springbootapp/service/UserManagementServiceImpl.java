package io.subham.springbootapp.service;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.subham.springbootapp.domain.Account;
import io.subham.springbootapp.domain.AccountDesignationMapping;
import io.subham.springbootapp.domain.Designation;
import io.subham.springbootapp.domain.DesignationAuthorityMapping;
import io.subham.springbootapp.dto.AccountDTO;
import io.subham.springbootapp.dto.AccountResponseDTO;
import io.subham.springbootapp.repository.AccountDesignationMappingRepository;
import io.subham.springbootapp.repository.AccountRepository;
import io.subham.springbootapp.repository.DesignationRepository;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private DesignationRepository designationRepository;

	@Autowired
	private AccountDesignationMappingRepository accountDesignationMappingRepository;

	@Autowired
	private ConfigurableEnvironment env;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	@Transactional
	public ResponseEntity<String> createAccount(AccountDTO accountDTO) {

		try {
			Account account = new Account();
			account.setPassword(accountDTO.getPassword());
			account.setUserName(accountDTO.getUserName());
			Account accSave = accountRepository.save(account);

			AccountDesignationMapping accDesgMapping = new AccountDesignationMapping();
			accDesgMapping.setAccount(accSave);
			Designation designation = designationRepository.findById(accountDTO.getDesignationId());
			accDesgMapping.setDesignation(designation);
			accountDesignationMappingRepository.save(accDesgMapping);

			return ResponseEntity.ok().body(env.getProperty("user.create.success"));
		} catch (DataAccessException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public AccountResponseDTO getAccountDetails(Integer id) {
		Account account = accountRepository.findById(id);

		AccountResponseDTO responseDTO = new AccountResponseDTO();
		responseDTO.setAccName(account.getUserName());

		Set<Map<String, List<String>>> set = new HashSet<>();

		for (AccountDesignationMapping accDesgMapping : account.getAccountDesignationMapping()) {

			List<DesignationAuthorityMapping> designationAuthorities = accDesgMapping.getDesignation()
					.getDesignationAuthorityMapping();

			Map<String, List<String>> map = new LinkedHashMap<>();

			for (DesignationAuthorityMapping desgAuth : designationAuthorities) {

				List<String> authorityList = new LinkedList<>();

				if (map.containsKey(desgAuth.getDesignation().getDesg())) {
					map.get(desgAuth.getDesignation().getDesg()).add(desgAuth.getAuthority().getAuthority());
				} else {
					authorityList.add(desgAuth.getAuthority().getAuthority());
					map.put(desgAuth.getDesignation().getDesg(), authorityList);
				}

//				System.out.println(set);
				set.add(map);
//				System.out.println(set);
			}

		}

		Set<Map<String, List<String>>> collect = set.stream().distinct().collect(Collectors.toSet());
		responseDTO.setDesignation(collect);
		return responseDTO;
	}

}
