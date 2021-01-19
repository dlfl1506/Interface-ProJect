package com.cos.movie.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
	public List<Movie> findAll(){
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(1,"movie1",3.5,new Timestamp(System.currentTimeMillis())));
		movies.add(new Movie(2,"movie2",4.0,new Timestamp(System.currentTimeMillis())));
		movies.add(new Movie(3,"movie3",4.5,new Timestamp(System.currentTimeMillis())));
		movies.add(new Movie(4,"movie4",2.5,new Timestamp(System.currentTimeMillis())));
		movies.add(new Movie(5,"movie5",1.5,new Timestamp(System.currentTimeMillis())));
		movies.add(new Movie(6,"movie6",2.5,new Timestamp(System.currentTimeMillis())));
		movies.add(new Movie(7,"movie7",2.0,new Timestamp(System.currentTimeMillis())));
		movies.add(new Movie(8,"movie8",1.0,new Timestamp(System.currentTimeMillis())));
		return movies;
	}
	
	public Movie findById(int id) {
		return new Movie(8,"movie8",1.0,new Timestamp(System.currentTimeMillis()));
	}
	
	public void save(JoinReqDto dto) {
		System.out.println("DB에 insert 하기");
	}
	
	public void delete(int id) {
		System.out.println("DB에 삭제하기");
	}
	
	public void update (int id,UpdateReqDto dto) {
		System.out.println("DB에 수정하기");
	}
}
