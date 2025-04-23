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

import com.entity.Xiaoshoujilu;
import com.server.XiaoshoujiluServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class XiaoshoujiluController {
	@Resource
	private XiaoshoujiluServer xiaoshoujiluService;


   
	@RequestMapping("addXiaoshoujilu.do")
	public String addXiaoshoujilu(HttpServletRequest request,Xiaoshoujilu xiaoshoujilu,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		xiaoshoujilu.setAddtime(time.toString().substring(0, 19));
		xiaoshoujiluService.add(xiaoshoujilu);
		String dd="update kuangwuxinxi set kucun=kucun-"+xiaoshoujilu.getXiaoshoushuliang()+" where kuangwubianhao='"+xiaoshoujilu.getKuangwubianhao()+"'";
		System.out.print(dd);
		db dbo = new db();
		dbo.hsgexecute(dd);
		String cc="update kuangwuxinxi set xiaoliang=xiaoliang+"+xiaoshoujilu.getXiaoshoushuliang()+" where kuangwubianhao='"+xiaoshoujilu.getKuangwubianhao()+"'";
		System.out.print(cc);
		dbo.hsgexecute(cc);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "xiaoshoujiluList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:xiaoshoujiluList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateXiaoshoujilu.do")
	public String doUpdateXiaoshoujilu(int id,ModelMap map,Xiaoshoujilu xiaoshoujilu){
		xiaoshoujilu=xiaoshoujiluService.getById(id);
		map.put("xiaoshoujilu", xiaoshoujilu);
		return "xiaoshoujilu_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("xiaoshoujiluDetail.do")
	public String xiaoshoujiluDetail(int id,ModelMap map,Xiaoshoujilu xiaoshoujilu){
		xiaoshoujilu=xiaoshoujiluService.getById(id);
		map.put("xiaoshoujilu", xiaoshoujilu);
		return "xiaoshoujilu_detail";
	}
//	前台详细
	@RequestMapping("xsjlDetail.do")
	public String xsjlDetail(int id,ModelMap map,Xiaoshoujilu xiaoshoujilu){
		xiaoshoujilu=xiaoshoujiluService.getById(id);
		map.put("xiaoshoujilu", xiaoshoujilu);
		return "xiaoshoujiludetail";
	}
//	
	@RequestMapping("updateXiaoshoujilu.do")
	public String updateXiaoshoujilu(int id,ModelMap map,Xiaoshoujilu xiaoshoujilu,HttpServletRequest request,HttpSession session){
		xiaoshoujiluService.update(xiaoshoujilu);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:xiaoshoujiluList.do";
	}

//	分页查询
	@RequestMapping("xiaoshoujiluList.do")
	public String xiaoshoujiluList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiaoshoujilu xiaoshoujilu, String xiaoshoudanhao, String kuangwubianhao, String kuangwumingcheng, String leibie, String suoshukuangchang, String xiaoliang, String kucun, String jiage, String xiaoshoushuliang1,String xiaoshoushuliang2, String xiaoshoujine, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
		if(kuangwubianhao==null||kuangwubianhao.equals("")){pmap.put("kuangwubianhao", null);}else{pmap.put("kuangwubianhao", kuangwubianhao);}
		if(kuangwumingcheng==null||kuangwumingcheng.equals("")){pmap.put("kuangwumingcheng", null);}else{pmap.put("kuangwumingcheng", kuangwumingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(suoshukuangchang==null||suoshukuangchang.equals("")){pmap.put("suoshukuangchang", null);}else{pmap.put("suoshukuangchang", suoshukuangchang);}
		if(xiaoliang==null||xiaoliang.equals("")){pmap.put("xiaoliang", null);}else{pmap.put("xiaoliang", xiaoliang);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(xiaoshoushuliang1==null||xiaoshoushuliang1.equals("")){pmap.put("xiaoshoushuliang1", null);}else{pmap.put("xiaoshoushuliang1", xiaoshoushuliang1);}
		if(xiaoshoushuliang2==null||xiaoshoushuliang2.equals("")){pmap.put("xiaoshoushuliang2", null);}else{pmap.put("xiaoshoushuliang2", xiaoshoushuliang2);}
		if(xiaoshoujine==null||xiaoshoujine.equals("")){pmap.put("xiaoshoujine", null);}else{pmap.put("xiaoshoujine", xiaoshoujine);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=xiaoshoujiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiaoshoujilu> list=xiaoshoujiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiaoshoujilu_list";
	}
	
	
	
	@RequestMapping("xsjlList.do")
	public String xsjlList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiaoshoujilu xiaoshoujilu, String xiaoshoudanhao, String kuangwubianhao, String kuangwumingcheng, String leibie, String suoshukuangchang, String xiaoliang, String kucun, String jiage, String xiaoshoushuliang1,String xiaoshoushuliang2, String xiaoshoujine, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xiaoshoudanhao==null||xiaoshoudanhao.equals("")){pmap.put("xiaoshoudanhao", null);}else{pmap.put("xiaoshoudanhao", xiaoshoudanhao);}
		if(kuangwubianhao==null||kuangwubianhao.equals("")){pmap.put("kuangwubianhao", null);}else{pmap.put("kuangwubianhao", kuangwubianhao);}
		if(kuangwumingcheng==null||kuangwumingcheng.equals("")){pmap.put("kuangwumingcheng", null);}else{pmap.put("kuangwumingcheng", kuangwumingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(suoshukuangchang==null||suoshukuangchang.equals("")){pmap.put("suoshukuangchang", null);}else{pmap.put("suoshukuangchang", suoshukuangchang);}
		if(xiaoliang==null||xiaoliang.equals("")){pmap.put("xiaoliang", null);}else{pmap.put("xiaoliang", xiaoliang);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(xiaoshoushuliang1==null||xiaoshoushuliang1.equals("")){pmap.put("xiaoshoushuliang1", null);}else{pmap.put("xiaoshoushuliang1", xiaoshoushuliang1);}
		if(xiaoshoushuliang2==null||xiaoshoushuliang2.equals("")){pmap.put("xiaoshoushuliang2", null);}else{pmap.put("xiaoshoushuliang2", xiaoshoushuliang2);}
		if(xiaoshoujine==null||xiaoshoujine.equals("")){pmap.put("xiaoshoujine", null);}else{pmap.put("xiaoshoujine", xiaoshoujine);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=xiaoshoujiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiaoshoujilu> list=xiaoshoujiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiaoshoujilulist";
	}
	
	@RequestMapping("deleteXiaoshoujilu.do")
	public String deleteXiaoshoujilu(int id,HttpServletRequest request){
		xiaoshoujiluService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:xiaoshoujiluList.do";
	}
	
	
}
