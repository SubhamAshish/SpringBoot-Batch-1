package io.subham.springbootapp.dto;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class AccountResponseDTO {

	private String accName;

	private Set<Map<String, List<String>>> designation;

}



//change password
//resetpassword
//update user-info
//get all user info
