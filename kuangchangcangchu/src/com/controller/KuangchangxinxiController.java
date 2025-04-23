package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Kuangchangxinxi;
import com.server.KuangchangxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class KuangchangxinxiController {
	@Resource
	private KuangchangxinxiServer kuangchangxinxiService;


   
	@RequestMapping("addKuangchangxinxi.do")
	public String addKuangchangxinxi(HttpServletRequest request,Kuangchangxinxi kuangchangxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		kuangchangxinxi.setAddtime(time.toString().substring(0, 19));
		kuangchangxinxiService.add(kuangchangxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "kuangchangxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:kuangchangxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateKuangchangxinxi.do")
	public String doUpdateKuangchangxinxi(int id,ModelMap map,Kuangchangxinxi kuangchangxinxi){
		kuangchangxinxi=kuangchangxinxiService.getById(id);
		map.put("kuangchangxinxi", kuangchangxinxi);
		return "kuangchangxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("kuangchangxinxiDetail.do")
	public String kuangchangxinxiDetail(int id,ModelMap map,Kuangchangxinxi kuangchangxinxi){
		kuangchangxinxi=kuangchangxinxiService.getById(id);
		map.put("kuangchangxinxi", kuangchangxinxi);
		return "kuangchangxinxi_detail";
	}
//	前台详细
	@RequestMapping("kcxxDetail.do")
	public String kcxxDetail(int id,ModelMap map,Kuangchangxinxi kuangchangxinxi){
		kuangchangxinxi=kuangchangxinxiService.getById(id);
		map.put("kuangchangxinxi", kuangchangxinxi);
		return "kuangchangxinxidetail";
	}
//	
	@RequestMapping("updateKuangchangxinxi.do")
	public String updateKuangchangxinxi(int id,ModelMap map,Kuangchangxinxi kuangchangxinxi,HttpServletRequest request,HttpSession session){
		kuangchangxinxiService.update(kuangchangxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:kuangchangxinxiList.do";
	}

//	分页查询
	@RequestMapping("kuangchangxinxiList.do")
	public String kuangchangxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kuangchangxinxi kuangchangxinxi, String kuangchangmingcheng){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(kuangchangmingcheng==null||kuangchangmingcheng.equals("")){pmap.put("kuangchangmingcheng", null);}else{pmap.put("kuangchangmingcheng", kuangchangmingcheng);}		
		int total=kuangchangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kuangchangxinxi> list=kuangchangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kuangchangxinxi_list";
	}
	
	
	
	@RequestMapping("kcxxList.do")
	public String kcxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kuangchangxinxi kuangchangxinxi, String kuangchangmingcheng){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(kuangchangmingcheng==null||kuangchangmingcheng.equals("")){pmap.put("kuangchangmingcheng", null);}else{pmap.put("kuangchangmingcheng", kuangchangmingcheng);}		
		int total=kuangchangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kuangchangxinxi> list=kuangchangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kuangchangxinxilist";
	}
	
	@RequestMapping("deleteKuangchangxinxi.do")
	public String deleteKuangchangxinxi(int id,HttpServletRequest request){
		kuangchangxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:kuangchangxinxiList.do";
	}
	
	
}
