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

import com.entity.Kuangwuxinxi;
import com.server.KuangwuxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class KuangwuxinxiController {
	@Resource
	private KuangwuxinxiServer kuangwuxinxiService;


   
	@RequestMapping("addKuangwuxinxi.do")
	public String addKuangwuxinxi(HttpServletRequest request,Kuangwuxinxi kuangwuxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		kuangwuxinxi.setAddtime(time.toString().substring(0, 19));
		kuangwuxinxiService.add(kuangwuxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "kuangwuxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:kuangwuxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateKuangwuxinxi.do")
	public String doUpdateKuangwuxinxi(int id,ModelMap map,Kuangwuxinxi kuangwuxinxi){
		kuangwuxinxi=kuangwuxinxiService.getById(id);
		map.put("kuangwuxinxi", kuangwuxinxi);
		return "kuangwuxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("kuangwuxinxiDetail.do")
	public String kuangwuxinxiDetail(int id,ModelMap map,Kuangwuxinxi kuangwuxinxi){
		kuangwuxinxi=kuangwuxinxiService.getById(id);
		map.put("kuangwuxinxi", kuangwuxinxi);
		return "kuangwuxinxi_detail";
	}
//	前台详细
	@RequestMapping("kwxxDetail.do")
	public String kwxxDetail(int id,ModelMap map,Kuangwuxinxi kuangwuxinxi){
		kuangwuxinxi=kuangwuxinxiService.getById(id);
		map.put("kuangwuxinxi", kuangwuxinxi);
		return "kuangwuxinxidetail";
	}
//	
	@RequestMapping("updateKuangwuxinxi.do")
	public String updateKuangwuxinxi(int id,ModelMap map,Kuangwuxinxi kuangwuxinxi,HttpServletRequest request,HttpSession session){
		kuangwuxinxiService.update(kuangwuxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:kuangwuxinxiList.do";
	}

//	分页查询
	@RequestMapping("kuangwuxinxiList.do")
	public String kuangwuxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kuangwuxinxi kuangwuxinxi, String kuangwubianhao, String kuangwumingcheng, String leibie, String suoshukuangchang, String xiaoliang1,String xiaoliang2, String kucun1,String kucun2, String jiage1,String jiage2, String tupian, String kuangwujianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(kuangwubianhao==null||kuangwubianhao.equals("")){pmap.put("kuangwubianhao", null);}else{pmap.put("kuangwubianhao", kuangwubianhao);}		if(kuangwumingcheng==null||kuangwumingcheng.equals("")){pmap.put("kuangwumingcheng", null);}else{pmap.put("kuangwumingcheng", kuangwumingcheng);}		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}		if(suoshukuangchang==null||suoshukuangchang.equals("")){pmap.put("suoshukuangchang", null);}else{pmap.put("suoshukuangchang", suoshukuangchang);}		if(xiaoliang1==null||xiaoliang1.equals("")){pmap.put("xiaoliang1", null);}else{pmap.put("xiaoliang1", xiaoliang1);}		if(xiaoliang2==null||xiaoliang2.equals("")){pmap.put("xiaoliang2", null);}else{pmap.put("xiaoliang2", xiaoliang2);}		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(kuangwujianjie==null||kuangwujianjie.equals("")){pmap.put("kuangwujianjie", null);}else{pmap.put("kuangwujianjie", kuangwujianjie);}		
		int total=kuangwuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kuangwuxinxi> list=kuangwuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kuangwuxinxi_list";
	}
	
	
	
	@RequestMapping("kwxxList.do")
	public String kwxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kuangwuxinxi kuangwuxinxi, String kuangwubianhao, String kuangwumingcheng, String leibie, String suoshukuangchang, String xiaoliang1,String xiaoliang2, String kucun1,String kucun2, String jiage1,String jiage2, String tupian, String kuangwujianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(kuangwubianhao==null||kuangwubianhao.equals("")){pmap.put("kuangwubianhao", null);}else{pmap.put("kuangwubianhao", kuangwubianhao);}		if(kuangwumingcheng==null||kuangwumingcheng.equals("")){pmap.put("kuangwumingcheng", null);}else{pmap.put("kuangwumingcheng", kuangwumingcheng);}		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}		if(suoshukuangchang==null||suoshukuangchang.equals("")){pmap.put("suoshukuangchang", null);}else{pmap.put("suoshukuangchang", suoshukuangchang);}		if(xiaoliang1==null||xiaoliang1.equals("")){pmap.put("xiaoliang1", null);}else{pmap.put("xiaoliang1", xiaoliang1);}		if(xiaoliang2==null||xiaoliang2.equals("")){pmap.put("xiaoliang2", null);}else{pmap.put("xiaoliang2", xiaoliang2);}		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(kuangwujianjie==null||kuangwujianjie.equals("")){pmap.put("kuangwujianjie", null);}else{pmap.put("kuangwujianjie", kuangwujianjie);}		
		int total=kuangwuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kuangwuxinxi> list=kuangwuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kuangwuxinxilist";
	}
	
	@RequestMapping("deleteKuangwuxinxi.do")
	public String deleteKuangwuxinxi(int id,HttpServletRequest request){
		kuangwuxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:kuangwuxinxiList.do";
	}
	
	
}
