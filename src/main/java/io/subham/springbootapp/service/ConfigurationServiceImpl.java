package io.subham.springbootapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.subham.springbootapp.domain.Authority;
import io.subham.springbootapp.domain.Designation;
import io.subham.springbootapp.domain.DesignationAuthorityMapping;
import io.subham.springbootapp.repository.AuthorityRepository;
import io.subham.springbootapp.repository.DesignationAuthorityMappingRepository;
import io.subham.springbootapp.repository.DesignationRepository;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

	@Autowired
	private DesignationRepository designationRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;

	@Autowired
	private DesignationAuthorityMappingRepository designationAuthorityMappingRepository;

	@Override
	public ResponseEntity<String> config() {

		try {

			Designation designation = new Designation();
			designation.setDesg("ADMIN");
			Designation desg1 = designationRepository.save(designation);

			designation = new Designation();
			designation.setDesg("USER");
			Designation desg2 = designationRepository.save(designation);

			Authority authority = new Authority();
			authority.setAuthority("USER-MANAGEMENT");
			Authority auth1 = authorityRepository.save(authority);

			authority = new Authority();
			authority.setAuthority("REPORT");
			Authority auth2 = authorityRepository.save(authority);

			/**
			 * Admin having both the authorities
			 */
			DesignationAuthorityMapping desigAuthMapping = new DesignationAuthorityMapping();
			desigAuthMapping.setAuthority(auth1);
			desigAuthMapping.setDesignation(desg1);
			designationAuthorityMappingRepository.save(desigAuthMapping);

			desigAuthMapping = new DesignationAuthorityMapping();
			desigAuthMapping.setAuthority(auth2);
			desigAuthMapping.setDesignation(desg1);
			designationAuthorityMappingRepository.save(desigAuthMapping);

			/**
			 * User-- REPORT
			 */
			desigAuthMapping = new DesignationAuthorityMapping();
			desigAuthMapping.setAuthority(auth2);
			desigAuthMapping.setDesignation(desg2);
			designationAuthorityMappingRepository.save(desigAuthMapping);

			return ResponseEntity.ok().body("success");
		} catch (DataAccessException e) {
			throw new RuntimeException(e);
		}

	}

}
