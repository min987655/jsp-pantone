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
public class FAQ {
	private int id;
	private int memberId;
	private String title;
	private String content;
	private int readCount;
	private Timestamp createDate;
}
