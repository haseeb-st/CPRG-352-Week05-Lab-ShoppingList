<%-- 
    Document   : shoppingList
    Created on : Oct 4, 2018, 11:15:07 AM
    Author     : 687159
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week 05 Lab - Shopping List</title>
    </head>
    
        <h1>Shopping List</h1>
        Hello, ${username} <a href="ShoppingList?action=logout">Log Out</a><br>
        <h2>List</h2>
        <form method="POST" action="ShoppingList?action=add">
            Add Item: <input type="text" name="item"><input type="submit" name="add" value="Add"><br>
        </form>
        ${addM}
        ${deleteM}
        ${errorM}<br>
        <form method="POST" action="ShoppingList?action=delete">
        <c:forEach var="a" items="${itemList}">
            <tr>
                <td><input type="radio" name="select" value="${a}">${a}</td><br>
            </tr>
        </c:forEach>
            <input type="submit" name="delete" value="Delete">
        </form>