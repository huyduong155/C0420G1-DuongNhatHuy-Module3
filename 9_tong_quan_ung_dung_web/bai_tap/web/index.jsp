<%--
  Created by IntelliJ IDEA.
  User: sf book
  Date: 7/24/2020
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <form action="/DiscoundServletPath" method="get">
    <label>Product Description</label>
    <input type="text" name="ProductDescription">
    <label>List Price</label>
    <input type="text" name="ListPrice">
    <label>Discount Percent</label>
    <input type="text" name="DiscountPercent">
    <input type="submit" value="Calculate Discount">
  </form>
  </body>
</html>
