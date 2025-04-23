<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>销售记录详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  销售记录详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>销售单号：</td><td width='39%'>${xiaoshoujilu.xiaoshoudanhao}</td>     <td width='11%'>矿物编号：</td><td width='39%'>${xiaoshoujilu.kuangwubianhao}</td></tr><tr>     <td width='11%'>矿物名称：</td><td width='39%'>${xiaoshoujilu.kuangwumingcheng}</td>     <td width='11%'>类别：</td><td width='39%'>${xiaoshoujilu.leibie}</td></tr><tr>     <td width='11%'>所属矿场：</td><td width='39%'>${xiaoshoujilu.suoshukuangchang}</td>     <td width='11%'>销量：</td><td width='39%'>${xiaoshoujilu.xiaoliang}</td></tr><tr>     <td width='11%'>库存：</td><td width='39%'>${xiaoshoujilu.kucun}</td>     <td width='11%'>价格：</td><td width='39%'>${xiaoshoujilu.jiage}</td></tr><tr>     <td width='11%'>销售数量：</td><td width='39%'>${xiaoshoujilu.xiaoshoushuliang}</td>     <td width='11%'>销售金额：</td><td width='39%'>${xiaoshoujilu.xiaoshoujine}</td></tr><tr>     <td width='11%'>备注：</td><td width='39%'>${xiaoshoujilu.beizhu}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

