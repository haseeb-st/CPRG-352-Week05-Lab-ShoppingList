<%-- 
    Document   : register
    Created on : Oct 4, 2018, 10:51:18 AM
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
        <form method="POST"  action="ShoppingList?action=register">
            Username: <input type="text" name="username"><input type="submit" value="Register Name">
                      <input type="hidden" name="hidden" value="username">
        </form>        
        ${errorM}
        ${logM}
    </body>
</html>
