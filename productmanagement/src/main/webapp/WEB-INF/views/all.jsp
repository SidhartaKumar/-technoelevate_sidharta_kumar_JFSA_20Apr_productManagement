<%@page import="com.te.productmanagement.beans.ProductInfoBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% ArrayList<ProductInfoBean> arr=(ArrayList) request.getAttribute("list");
    String name = (String) request.getAttribute("name");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if (arr != null) {
%>
<fieldset>
<legend>All Records</legend>
<table  border="1" style="width:100%">
<tr>
<th>ID</th>
<th>Name</th>
<th>Date of Birth</th>
</tr>
<%
for (ProductInfoBean infoBean : arr) {
%>
<tr>
<td><%=infoBean.getPid()%></td>
<td><%=infoBean.getPname()%></td>
<td><%=infoBean.getMfd()%></td>
<td><%=infoBean.getExp() %></td>
<td><%=infoBean.getPrice() %></td>
<td><%=infoBean.getQuant()%></td>
</tr>
<%
}
%>
</table>

</fieldset>
<%
}
%>

</body>
</html>