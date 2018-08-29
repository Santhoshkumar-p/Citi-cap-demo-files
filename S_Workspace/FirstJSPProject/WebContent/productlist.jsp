<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="demo.data.*,java.util.List,demo.app.business.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
function validate(){
	var the_category = document.getElementById("category").value;
	if(the_category == "Choose a category"){
		alert("Choose a category");
		return false;
	}
	else{
		return true;
	}
}
</script>
<title>Product List</title>
</head>
<body>
<h2>Product List</h2>
<% 
	MySQLData data = new MySQLData();
	List<Category> categories = data.getCategories();
%>
<form action='productlist.jsp' method='get' onsubmit="return validate()" >
	
	<p>Category <select name="category" id="category">
	<%
		out.println("");
		out.println("<option value='Choose a category' selected>Choose a category</option>");
		for(Category c: categories){
			out.println("<option value='" + c.getName() + "'>" + c.getName() + "</option>");
		}
	%>
	</select>&nbsp;<input type="submit" value="Get Products" /></p>
</form>
<%
		if(request.getParameter("category")!=null){
			 //HashSet<String> categories_viewed;
			if(session.getAttribute("categories")==null){
				//categories_viewed = new HashSet<>();
				//categories_viewed.add(request.getParameter("category"));
			}
			else{
				//categories_viewed = (HashSet<String>)session.getAttribute("categories");
				//categories_viewed.add(request.getParameter("category"));	
			}
			//session.setAttribute("categories",categories_viewed);
			out.println("<h3>Categories viewed in this session ");
			//for(String c: categories_viewed){
				//out.print(c + "&nbsp;");
			//}
			out.print("</h3>");
			out.println("<h3>" + request.getParameter("category") + "</h3>");
			
			List<String> products = data.getProducts(request.getParameter("category"));
			for(String product:products){
				out.print(product + "<br>");
			}
		}
%>
<br>
<a href="index.html">Home page</a>
</body>
</html>