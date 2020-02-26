package com.yay.serivce.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yay.dao.MovieDao;
import com.yay.domain.Movie;
import com.yay.serivce.MovieSerivce;
import com.yay.vo.MovieVo;


@Service
public class MovieSerivceImpl implements MovieSerivce {

	@Autowired
	private MovieDao moviedao;
	@Override
	public List<Movie> selects(MovieVo movievo) {

		return moviedao.selects(movievo);
	}
	@Override
	public boolean delete(Integer[] ids) {
		
		int i = moviedao.delete(ids);
		
		return i>0;
	}
	@Override
	public void add(MovieVo movievo) {
		
		moviedao.add(movievo);
		
	}
	
	

}
