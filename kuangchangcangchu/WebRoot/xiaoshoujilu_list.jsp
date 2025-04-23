<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>销售记录查询</TITLE>
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">销售记录列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="xiaoshoujiluList.do" name="myform" method="post">
									查询   销售单号：<input name="xiaoshoudanhao" type="text" id="xiaoshoudanhao" style='border:solid 1px #000000; color:#666666' size="12" />  矿物编号：<input name="kuangwubianhao" type="text" id="kuangwubianhao" style='border:solid 1px #000000; color:#666666' size="12" />  矿物名称：<input name="kuangwumingcheng" type="text" id="kuangwumingcheng" style='border:solid 1px #000000; color:#666666' size="12" />  类别：<input name="leibie" type="text" id="leibie" style='border:solid 1px #000000; color:#666666' size="12" />  所属矿场：<input name="suoshukuangchang" type="text" id="suoshukuangchang" style='border:solid 1px #000000; color:#666666' size="12" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center'>销售单号</td>    <td align='center'>矿物编号</td>    <td align='center'>矿物名称</td>    <td align='center'>类别</td>    <td align='center'>所属矿场</td>    <td align='center'>销量</td>    <td align='center'>库存</td>    <td align='center'>价格</td>    <td align='center'>销售数量</td>    <td align='center'>销售金额</td>        
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.xiaoshoudanhao}</td>    <td>${u.kuangwubianhao}</td>    <td>${u.kuangwumingcheng}</td>    <td>${u.leibie}</td>    <td>${u.suoshukuangchang}</td>    <td>${u.xiaoliang}</td>    <td>${u.kucun}</td>    <td>${u.jiage}</td>    <td>${u.xiaoshoushuliang}</td>    <td>${u.xiaoshoujine}</td>        
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a href="doUpdateXiaoshoujilu.do?id=${u.id }">编辑</a>  <a href="deleteXiaoshoujilu.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a href="xiaoshoujiluDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from xiaoshoujilu where 1=1 ";
				if(request.getParameter("xiaoshoudanhao")=="" ||request.getParameter("xiaoshoudanhao")==null ){}else{String nxiaoshoudanhao=new String(request.getParameter("xiaoshoudanhao").getBytes("8859_1"));if(nxiaoshoudanhao.contains("?")){nxiaoshoudanhao=request.getParameter("xiaoshoudanhao");}sql=sql+" and xiaoshoudanhao like '%"+nxiaoshoudanhao+"%'";}if(request.getParameter("kuangwubianhao")=="" ||request.getParameter("kuangwubianhao")==null ){}else{String nkuangwubianhao=new String(request.getParameter("kuangwubianhao").getBytes("8859_1"));if(nkuangwubianhao.contains("?")){nkuangwubianhao=request.getParameter("kuangwubianhao");}sql=sql+" and kuangwubianhao like '%"+nkuangwubianhao+"%'";}if(request.getParameter("kuangwumingcheng")=="" ||request.getParameter("kuangwumingcheng")==null ){}else{String nkuangwumingcheng=new String(request.getParameter("kuangwumingcheng").getBytes("8859_1"));if(nkuangwumingcheng.contains("?")){nkuangwumingcheng=request.getParameter("kuangwumingcheng");}sql=sql+" and kuangwumingcheng like '%"+nkuangwumingcheng+"%'";}if(request.getParameter("leibie")=="" ||request.getParameter("leibie")==null ){}else{String nleibie=new String(request.getParameter("leibie").getBytes("8859_1"));if(nleibie.contains("?")){nleibie=request.getParameter("leibie");}sql=sql+" and leibie like '%"+nleibie+"%'";}if(request.getParameter("suoshukuangchang")=="" ||request.getParameter("suoshukuangchang")==null ){}else{String nsuoshukuangchang=new String(request.getParameter("suoshukuangchang").getBytes("8859_1"));if(nsuoshukuangchang.contains("?")){nsuoshukuangchang=request.getParameter("suoshukuangchang");}sql=sql+" and suoshukuangchang like '%"+nsuoshukuangchang+"%'";}
			sql+=" order by id desc";
double xiaoshoujinez=0;
							
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						xiaoshoujinez=xiaoshoujinez+Float.valueOf(RS_result.getString("xiaoshoujine")).floatValue();
						
						
			 }
			%>
		共计销售金额:<%=xiaoshoujinez%>； 
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="xiaoshoujiluList.do?page=1" >首页</a>
             <a href="xiaoshoujiluList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="xiaoshoujiluList.do?page=${page.page+1 }">下一页</a>
			<a href="xiaoshoujiluList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
