package com.cos.movie.web;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.movie.domain.CommonDto;
import com.cos.movie.domain.JoinReqDto;
import com.cos.movie.domain.Movie;
import com.cos.movie.domain.MovieRepository;
import com.cos.movie.domain.UpdateReqDto;

@RestController
public class MovieController {

	private MovieRepository movieRepository;
	
	// DI = 의존성 주입
	public MovieController(MovieRepository movieRepository) {
		this.movieRepository=movieRepository;
	}
	
	@GetMapping("/movie")
	public List<Movie> findAll() {
		System.out.println("findAll()");
		
		return movieRepository.findAll();
	}

	@GetMapping("/movie/{id}")
	public Movie findById(@PathVariable int id) {
		System.out.println("findById()"+id);
		return movieRepository.findById(id);
	}

	@PostMapping("/movie")
	public CommonDto<?> save(@Valid @RequestBody JoinReqDto dto, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) { 
			Map<String,String> errorMap = new HashMap<>();
			
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(),error.getDefaultMessage());
			}
			return new CommonDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),"fail",errorMap); 
		}
		
		System.out.println("save()");
		System.out.println("dto"+dto);
		movieRepository.save(dto);
		return new CommonDto<>(HttpStatus.OK.value(),"OK",dto);
	}

	@DeleteMapping("/movie/{id}")
	public CommonDto delete(@PathVariable int id) {
		
		
		System.out.println("delete()");
		movieRepository.delete(id);
		return new CommonDto<>(HttpStatus.OK.value(),"OK");
	}

	@PutMapping("/movie/{id}")
	public CommonDto  update(@PathVariable int id, @Valid @RequestBody UpdateReqDto dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) { 
			Map<String,String> errorMap = new HashMap<>();
			
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(),error.getDefaultMessage());
			}
			return new CommonDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),"fail",errorMap); 
		}
		
		System.out.println("update()");
		movieRepository.update(id, dto);
		return new CommonDto<>(HttpStatus.OK.value(),"OK");
	}
}
