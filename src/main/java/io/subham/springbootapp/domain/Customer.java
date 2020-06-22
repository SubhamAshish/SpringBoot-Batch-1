package io.subham.springbootapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	@Column(name = "id_pk")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "cust_name")
	private String name;

	private String address;

	@LazyToOne(LazyToOneOption.NO_PROXY)
	@OneToOne(mappedBy = "customer", fetch = FetchType.LAZY)
	private CustomerOrder customerOrder;

}
