package com.cos.pantone.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailResponseDto {
	private PaletteResponseDto paletteDto;
	private List<ReplyResponseDto> replyDtos;
}
