<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="xiaoshoujiluhsgb" scope="page" class="com.bean.XiaoshoujiluBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=xiaoshoujilu.xls");
%>
<html>
  <head>
    <title>���ۼ�¼</title>
  </head>

  <body >
 <%
			String sql="select * from xiaoshoujilu  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>���۵���</td>    <td align='center'>������</td>    <td align='center'>��������</td>    <td align='center'>���</td>    <td align='center'>������</td>    <td align='center'>����</td>    <td align='center'>���</td>    <td align='center'>�۸�</td>    <td align='center'>��������</td>    <td align='center'>���۽��</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
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

