package io.subham.springbootapp.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Account {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acc_id_pk")
	@Id
	private Integer id;

	private String userName;

	@Column(name = "password", length = 16)
	private String password;

	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	List<AccountDesignationMapping> accountDesignationMapping;

}
