package com.cos.pantone.dto;

import com.cos.pantone.model.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailResponseDto {
	private Board board;
	private String username;
}
