<%--
  Created by IntelliJ IDEA.
  User: sf book
  Date: 7/24/2020
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>final</title>
</head>
<body>
<p style="color: blue">Product Description: <%=request.getAttribute("ProductDescription")%></p>
<p style="color: red">Discount Amount: <%=request.getAttribute("resultServlet")%></p>
<p style="color: red">Discount Price: <%=request.getAttribute("afterprice")%></p>
</body>
</html>
