<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="kuangwuxinxihsgb" scope="page" class="com.bean.KuangwuxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=kuangwuxinxi.xls");
%>
<html>
  <head>
    <title>矿物信息</title>
  </head>

  <body >
 <%
			String sql="select * from kuangwuxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>矿物编号</td>    <td align='center'>矿物名称</td>    <td align='center'>类别</td>    <td align='center'>所属矿场</td>    <td align='center'>销量</td>    <td align='center'>库存</td>    <td align='center'>价格</td>    <td  width='90' align='center'>图片</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=kuangwuxinxihsgb.getAllKuangwuxinxi(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.kuangwubianhao}</td>    <td>${u.kuangwumingcheng}</td>    <td>${u.leibie}</td>    <td>${u.suoshukuangchang}</td>    <td>${u.xiaoliang}</td>    <td>${u.kucun}</td>    <td>${u.jiage}</td>    <td width='90' align='center'><a href='${u.tupian}' target='_blank'><img src='${u.tupian}' width=88 height=99 border=0 /></a></td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

