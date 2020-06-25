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
public class Reply {
	private int id;
	private int memberId;
	private int boardId;
	private String content;
	private Timestamp createDate;
}
