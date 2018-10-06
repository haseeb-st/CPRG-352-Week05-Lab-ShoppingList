<%-- 
    Document   : shoppingList
    Created on : Oct 4, 2018, 11:15:07 AM
    Author     : 687159
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week 05 Lab - Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello, ${username} <a href="ShoppingList?action=logout">Log Out</a><br>
        <h2>List</h2>
        <form method="POST" action="ShoppingList?action=add">
            Add Item: <input type="text" name="item"><input type="submit" value="Add">
        </form>
        <c:forEach var="listItem" items="${itemList}">
            <tr>
            <input type="radius" name="check"><td>${listItem.item}</td>
            </tr>
        </c:forEach> 
    </body>
</html>
