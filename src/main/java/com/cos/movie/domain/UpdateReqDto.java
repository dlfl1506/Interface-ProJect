package com.cos.movie.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UpdateReqDto {
	
	@NotNull(message = "영화제목 키값이 없습니다")
	@NotBlank(message = "영화제목 을 입력하세요")
	@Size(max = 20,message = "제목이 20자리를  초과할수없습니다.")
	private String title;

	private double rating;
}
