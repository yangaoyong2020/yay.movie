package com.yay.serivce;

import java.util.List;

import com.yay.domain.Movie;
import com.yay.vo.MovieVo;


public interface MovieSerivce {
	

	boolean delete(Integer[] ids);

	List<Movie> selects(MovieVo movievo);

	void add(MovieVo movievo);

}
