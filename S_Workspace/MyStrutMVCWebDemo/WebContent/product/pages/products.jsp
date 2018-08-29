<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
<style>

table {
    border-collapse: collapse;
    width: 80%;
}

th, td {
    text-align: left;
    padding: 8px;
}
tr:nth-child(even){background-color: #f2f2f2}
th {
    background-color: #4CAF50;
    color: white;
}
</style>
<script>
function doDelete(){
	return confirm("Are you sure you want to delete this record?");
}
</script>
</head>
<body>
<h2>Product List</h2>
<table>
<tr>
	<th>Make</th><th>Categoryid</th><th>Price</th><th>Delete</th>
</tr>
<s:iterator value="products">
    <tr>
        <td><a href='update?id=<s:property value="id" />'>
        <s:property value="make" />(update)</a></td>
        <td><s:property value="categoryid" /></td>
        <td><s:property value="price" /></td>
        <td><a href='delete?id=<s:property value="id" />' onclick="return doDelete()" >
        Delete</a></td>
    </tr>
</s:iterator>
</table>
<br />
<s:iterator value="pages">
	<s:url var="vurl" action="thepage">
  		<s:param name="page"><s:property /></s:param>
	</s:url>
	<a href="${vurl}"><s:property /></a>
</s:iterator>
<br><br>
<a href="../index.html">Home</a>
</body>
</html>