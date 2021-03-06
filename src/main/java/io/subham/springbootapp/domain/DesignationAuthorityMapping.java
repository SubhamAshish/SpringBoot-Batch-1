package io.subham.springbootapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class DesignationAuthorityMapping {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "desg_id_fk")
	private Designation designation;

	@ManyToOne
	@JoinColumn(name = "authority_id_fk")
	private Authority authority;

}
