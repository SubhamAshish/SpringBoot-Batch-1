package io.subham.springbootapp.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class CustomerDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1129602941255666722L;

	private Integer id; 
	
	private String fullName;

	private String address;

}
