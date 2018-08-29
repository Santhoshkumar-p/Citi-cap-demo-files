<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Product</title>
</head>
<body>
<h2>Enter Product Details</h2>
<s:form action="add"> 
      <s:textfield name="make" label="Product" size="40" />
      <s:select  name="categoryid" list="categories" label="Category" 
      listKey="id" listValue="name"/>
      <s:textfield name="price"  label ="Price" size="5"/>
      <s:hidden name="id" value="-1"/> 
      <s:submit/>
</s:form> 
</body>
</html>