<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="xiaoshoujiluhsgb" scope="page" class="com.bean.XiaoshoujiluBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=xiaoshoujilu.xls");
%>
<html>
  <head>
    <title>销售记录</title>
  </head>

  <body >
 <%
			String sql="select * from xiaoshoujilu  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>销售单号</td>    <td align='center'>矿物编号</td>    <td align='center'>矿物名称</td>    <td align='center'>类别</td>    <td align='center'>所属矿场</td>    <td align='center'>销量</td>    <td align='center'>库存</td>    <td align='center'>价格</td>    <td align='center'>销售数量</td>    <td align='center'>销售金额</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=xiaoshoujiluhsgb.getAllXiaoshoujilu(13);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xiaoshoudanhao}</td>    <td>${u.kuangwubianhao}</td>    <td>${u.kuangwumingcheng}</td>    <td>${u.leibie}</td>    <td>${u.suoshukuangchang}</td>    <td>${u.xiaoliang}</td>    <td>${u.kucun}</td>    <td>${u.jiage}</td>    <td>${u.xiaoshoushuliang}</td>    <td>${u.xiaoshoujine}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

