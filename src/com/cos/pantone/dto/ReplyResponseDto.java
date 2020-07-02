package com.cos.pantone.dto;

import com.cos.pantone.model.Reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyResponseDto {
	private Reply reply;
	private String username;
	private String userProfile;
}
