package com.yay.dao;

import java.util.List;

import com.yay.domain.Movie;
import com.yay.vo.MovieVo;

public interface MovieDao {
	//Ä£ºý²éÑ¯
		List<Movie> selects(MovieVo movievo);

		int  delete(Integer[] ids);

		void add(MovieVo movievo);

		

		
}
