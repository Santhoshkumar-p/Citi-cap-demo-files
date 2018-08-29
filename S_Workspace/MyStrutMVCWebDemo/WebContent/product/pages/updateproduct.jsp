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
<h2>Edit Product Details</h2>
<s:form action="save"> 
      <s:textfield name="make" label="Make" value="%{product.make}" size="40"/>
      <s:select  name="categoryid" list="categories" label="Category" 
      listKey="id" listValue="name" value="%{product.categoryid}"/>
      <s:textfield name="price"  label ="Price" value="%{product.price}" size="5"/>
      <s:hidden name="id" value="%{product.id}" />
      <s:submit/>
</s:form> 
</body>
</html>