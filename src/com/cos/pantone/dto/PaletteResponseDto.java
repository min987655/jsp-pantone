package com.cos.pantone.dto;

import com.cos.pantone.model.Palette;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaletteResponseDto {
	private Palette palette;
	private String username;
}
