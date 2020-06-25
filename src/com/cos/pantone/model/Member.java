package com.cos.pantone.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
	private int id;
	private String username;
	private String password;
	private String email;
	private String userProfile;
	private String userRole;
	private Timestamp createDate;
}
