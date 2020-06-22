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
public class Authority {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auth_id_pk")
	@Id
	private Integer id;

	private String authority;

	@OneToMany(mappedBy = "authority",fetch=FetchType.LAZY)
	List<DesignationAuthorityMapping> designationAuthorityMapping;
}
