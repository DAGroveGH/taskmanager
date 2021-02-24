<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Add Task</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <div id="nav-bar">
            <h2 id="user-welcome">Welcome ${sessionName}</h2>
            <nav id="nav-links">
                <ul>
                    <li><a id="home" href="/home">Home</a></li>
                    <li><a id="logout" href="/logout">Logout</a></li>
                </ul>
            </nav>
        </div>
        <div class="container" id="task-container">
            <h2>Add A Task</h2>
            <p>${message}</p>
            <p>${error}</p>
            <form action="create-task" method="post">
                <input type="text" name="taskName" placeholder="Task name" required/><br>
                <label class="label">Start Date</label><br>
                <input type="date" name="startDate" required/><br>
                <label class="label">End Date</label><br>
                <input type="date" name="endDate" required/><br>
                <label class="label">Priority</label>
                <select name="severity" required>
                    <option value="low">Low</option>
                    <option value="medium">Medium</option>
                    <option value="high">High</option>
                </select><br>
                <textarea name="description" cols="30" rows="5" maxlength="80" placeholder="Enter a description..." required></textarea><br>
                <button type="submit" class="btn btn-primary">Add New Task</button>
            </form>
        </div>
    </body>
</html>