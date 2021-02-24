<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Add Task</title>
        <link rel="stylesheet" href="/css/styles.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h2>Are you sure you want to delete ${current.taskName}?</h2>
            <p>${message }</p>
            <p>${error}</p>
            <form action="/delete" method="post">
                <input type="hidden" name="taskId" value="${current.taskId }" readonly/>
                <button type="submit" class="btn btn-danger">Delete Task</button>
            </form>
        </div>
    </body>
</html>