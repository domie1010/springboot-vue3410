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
		<TITLE>修改矿物信息</TITLE>
	    
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
	document.location.href="kuangwuxinxi_add.jsp?id=<%=id%>";
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
			<form action="updateKuangwuxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改矿物信息<input type="hidden" name="id" value="${kuangwuxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">矿物编号：</td><td><input name='kuangwubianhao' type='text' id='kuangwubianhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">矿物名称：</td><td><input name='kuangwumingcheng' type='text' id='kuangwumingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">类别：</td><td><input name='leibie' type='text' id='leibie' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">所属矿场：</td><td><select name='suoshukuangchang' id='suoshukuangchang' style=' height:19px; border:solid 1px #000000; color:#666666'><%=connDbBean.hsggetoption("kuangchangxinxi","kuangchangmingcheng")%></select></td></tr>		<tr ><td width="200">销量：</td><td><input name='xiaoliang' type='text' id='xiaoliang' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelxiaoliang' />必需数字型</td></tr>		<tr ><td width="200">库存：</td><td><input name='kucun' type='text' id='kucun' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelkucun' />必需数字型</td></tr>		<tr ><td width="200">价格：</td><td><input name='jiage' type='text' id='jiage' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabeljiage' />必需数字型</td></tr>		<tr ><td width="200">图片：</td><td><input name='tupian' type='text' id='tupian' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('tupian')" style='border:solid 1px #000000; color:#666666'/></td></tr>		<tr ><td width="200">矿物简介：</td><td><textarea name='kuangwujianjie' cols='50' rows='5' id='kuangwujianjie' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.kuangwubianhao.value='${kuangwuxinxi.kuangwubianhao}';</script>	<script language="javascript">document.form1.kuangwumingcheng.value='${kuangwuxinxi.kuangwumingcheng}';</script>	<script language="javascript">document.form1.leibie.value='${kuangwuxinxi.leibie}';</script>	<script language="javascript">document.form1.suoshukuangchang.value='${kuangwuxinxi.suoshukuangchang}';</script>	<script language="javascript">document.form1.xiaoliang.value='${kuangwuxinxi.xiaoliang}';</script>	<script language="javascript">document.form1.kucun.value='${kuangwuxinxi.kucun}';</script>	<script language="javascript">document.form1.jiage.value='${kuangwuxinxi.jiage}';</script>	<script language="javascript">document.form1.tupian.value='${kuangwuxinxi.tupian}';</script>	<script language="javascript">document.form1.kuangwujianjie.value='${kuangwuxinxi.kuangwujianjie}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	            


return true;   
}   
popheight=450;
</script>  
