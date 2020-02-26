package com.yay.controller;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yay.domain.Movie;
import com.yay.serivce.MovieSerivce;
import com.yay.vo.MovieVo;

@Controller
public class MovieController {
	@Autowired
	private MovieSerivce movieserivce;
	
	@RequestMapping("selects")
	public String list(MovieVo movievo,Model m){
		//判断当前页数是否为空
		if(movievo.getPageNum()==null){
			movievo.setPageNum(1);
		}
		//使用分页插件
		PageHelper.startPage(movievo.getPageNum(), 3);
		
		List<Movie> list = movieserivce.selects(movievo);
		
		PageInfo<Movie> page = new PageInfo<Movie>(list);
		
		m.addAttribute("page",page);
		
		m.addAttribute("movievo",movievo);
		
		return "movies";
	}
	@ResponseBody
	@RequestMapping("delete")
	public Object delete(Integer[] ids){
		boolean fa= movieserivce.delete(ids);
		return fa;
	}
	//添加
	@RequestMapping("toAdd")
	public String toAdd(){
		
		return "add";
	}
	
	@RequestMapping("add")
	public String add(MovieVo movievo,MultipartFile myFile,HttpServletRequest request) throws IllegalStateException, IOException{
		//判断获取路劲
		if(!myFile.isEmpty()){
			//获取路径
			String realPath= request.getSession().getServletContext().getRealPath("/file")+"\\";
			//获取名称
			String originalFilename = myFile.getOriginalFilename();
			//获取格式
			String end = originalFilename.substring(originalFilename.lastIndexOf("."));
			//生成新名称
			String start = UUID.randomUUID().toString();
			//创建文件
			File file = new File(realPath+start+end);
			//文件复制
			myFile.transferTo(file);
			//储存名称
			movievo.setPig(start+end);
			//执行添加
			movieserivce.add(movievo);
		}
		return "redirect:selects";
	}
}
