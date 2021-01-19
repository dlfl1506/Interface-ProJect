package com.cos.movie.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Movie {
	private int id;
	private String title;
	private double rating;
	private Timestamp makeDate;
}
