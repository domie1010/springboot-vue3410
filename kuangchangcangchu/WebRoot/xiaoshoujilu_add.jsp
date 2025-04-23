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
		<TITLE>添加销售记录</TITLE>
	    

 	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>      
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="xiaoshoujilu_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="addXiaoshoujilu.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加销售记录</td>
						</tr>
						<tr ><td width="200">销售单号：</td><td><input name='xiaoshoudanhao' type='text' id='xiaoshoudanhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr ><td width="200">矿物编号：</td><td><input name='kuangwubianhao' type='text' id='kuangwubianhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.kuangwubianhao.value='<%=connDbBean.readzd("kuangwuxinxi","kuangwubianhao","id",request.getParameter("id"))%>';document.form1.kuangwubianhao.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">矿物名称：</td><td><input name='kuangwumingcheng' type='text' id='kuangwumingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666' readonly='readonly' /></td></tr><script language="javascript">document.form1.kuangwumingcheng.value='<%=connDbBean.readzd("kuangwuxinxi","kuangwumingcheng","id",request.getParameter("id"))%>';document.form1.kuangwumingcheng.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">类别：</td><td><input name='leibie' type='text' id='leibie' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.leibie.value='<%=connDbBean.readzd("kuangwuxinxi","leibie","id",request.getParameter("id"))%>';document.form1.leibie.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">所属矿场：</td><td><input name='suoshukuangchang' type='text' id='suoshukuangchang' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.suoshukuangchang.value='<%=connDbBean.readzd("kuangwuxinxi","suoshukuangchang","id",request.getParameter("id"))%>';document.form1.suoshukuangchang.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">销量：</td><td><input name='xiaoliang' type='text' id='xiaoliang' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.xiaoliang.value='<%=connDbBean.readzd("kuangwuxinxi","xiaoliang","id",request.getParameter("id"))%>';document.form1.xiaoliang.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">库存：</td><td><input name='kucun' type='text' id='kucun' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.kucun.value='<%=connDbBean.readzd("kuangwuxinxi","kucun","id",request.getParameter("id"))%>';document.form1.kucun.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">价格：</td><td><input name='jiage' type='text' id='jiage' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.jiage.value='<%=connDbBean.readzd("kuangwuxinxi","jiage","id",request.getParameter("id"))%>';document.form1.jiage.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">销售数量：</td><td><input name='xiaoshoushuliang' type='text' id='xiaoshoushuliang' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelxiaoshoushuliang' />必需数字型</td></tr>
		<tr 0><td width="200">销售金额：</td><td><input name='xiaoshoujine' type='text' id='xiaoshoujine' value='' onblur='' style='border:solid 1px #000000; color:#666666' readonly='readonly' /> 此项不必填写，系统自动计算</td></tr>
		<tr 1><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var xiaoshoushuliangobj = document.getElementById("xiaoshoushuliang"); if(xiaoshoushuliangobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(xiaoshoushuliangobj.value)){document.getElementById("clabelxiaoshoushuliang").innerHTML=""; }else{document.getElementById("clabelxiaoshoushuliang").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    if(parseInt(document.form1.kucun.value)<parseInt(document.form1.xiaoshoushuliang.value)){alert("对不起，库存必需大于销售数量");return false;}
	var xiaoshoujinej=1;if(document.getElementById("jiage").value!=""){xiaoshoujinej=xiaoshoujinej*parseFloat(document.getElementById("jiage").value);}if(document.getElementById("xiaoshoushuliang").value!=""){xiaoshoujinej=xiaoshoujinej*parseFloat(document.getElementById("xiaoshoushuliang").value);}document.getElementById("xiaoshoujine").value=xiaoshoujinej;
	


return true;   
}   
popheight=450;
</script>  
