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
		//�жϵ�ǰҳ���Ƿ�Ϊ��
		if(movievo.getPageNum()==null){
			movievo.setPageNum(1);
		}
		//ʹ�÷�ҳ���
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
	//���
	@RequestMapping("toAdd")
	public String toAdd(){
		
		return "add";
	}
	
	@RequestMapping("add")
	public String add(MovieVo movievo,MultipartFile myFile,HttpServletRequest request) throws IllegalStateException, IOException{
		//�жϻ�ȡ·��
		if(!myFile.isEmpty()){
			//��ȡ·��
			String realPath= request.getSession().getServletContext().getRealPath("/file")+"\\";
			//��ȡ����
			String originalFilename = myFile.getOriginalFilename();
			//��ȡ��ʽ
			String end = originalFilename.substring(originalFilename.lastIndexOf("."));
			//����������
			String start = UUID.randomUUID().toString();
			//�����ļ�
			File file = new File(realPath+start+end);
			//�ļ�����
			myFile.transferTo(file);
			//��������
			movievo.setPig(start+end);
			//ִ�����
			movieserivce.add(movievo);
		}
		return "redirect:selects";
	}
}
