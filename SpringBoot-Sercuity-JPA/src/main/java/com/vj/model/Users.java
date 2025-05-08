package com.vj.model;

import java.util.Set;


import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer unid;
	@Column(length = 20,unique = true)
	private String userName;
	@Column(length = 1000)
	private String password;
	@Column(length = 30)
	private String email;
	
	private Boolean status=true;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "ROLES",joinColumns = @JoinColumn(name = "USER_ID" ,referencedColumnName = "unid"))
	private Set<String> role;



}
