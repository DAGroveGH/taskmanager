<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Home</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <link rel="stylesheet" href="/css/styles.css">
    </head>

    <body>
        <div id="nav-bar">
            <h2 id="user-welcome">Welcome ${sessionName}</h2>
            <nav id="nav-links">
                <ul>
                    <li><a id="create-task" href="/create-task">Add Task</a></li>
                    <li><a id="logout" href="/logout">Logout</a></li>
                </ul>
            </nav>
        </div>
        <div class="container" id="table-container">
            <p>${message}</p>
            <p>${error}</p>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Task Name</th>
                        <th scope="col">Start Date</th>
                        <th scope="col">End Date</th>
                        <th scope="col">Description</th>
                        <th scope="col">Severity</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${tasks}" var="task">
                        <tr scope="row">
                            <td>${task.taskName}</td>
                            <td>${task.startDate}</td>
                            <td>${task.endDate}</td>
                            <td>${task.description}</td>
                            <td>${task.severity}</td>
                            <td><a href="/edit-task/${task.taskId}">Edit</a></td>
                            <td><a href="/delete-task/${task.taskId}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>