<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <link rel="stylesheet" href="/css/styles.css" type="text/css"></head>
    <body>
        <div class="container">
            <h2>Login</h2>
            <p>${message}</p>
            <p>${error}</p>
            <form action="/login" method="post">
                <input type="text" name="username" placeholder="Username" /><br>
                <input type="password" name="password" placeholder="Password" /><br>
                <button type="submit" class="btn btn-primary">Login</button><br>
                Don't have an account? Create one <a href="/register" >here</a>
            </form>
        </div>
    </body>
</html>