<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Edit Task</title>
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
            <h2>Edit A Task</h2>
            <p>${message }</p>
            <form action="../update" method="post">
                <input type="hidden" name="taskId" value="${current.taskId}" readonly/><br>
                <input type="text" name="taskName" placeholder="Task name" value="${current.taskName}"/><br>
                <label>Start Date</label><br>
                <input type="date" name="startDate" value="${current.startDate}"/><br>
                <label>End Date</label><br>
                <input type="date" name="endDate" value="${current.endDate}"/><br>

                <select name="severity">
                    <option value="low">Low</option>
                    <option value="medium">Medium</option>
                    <option value="high">High</option>
                </select><br>
                <textarea name="description" cols="30" rows="10">${current.description}</textarea><br>
                <button type="submit" class="btn btn-primary">Save Changes</button>
            </form><br>

            <div class="container">
                <h2>Current Saved Settings</h2>
                <p><label class="label">User: </label>${current.user.username}</p>
                <p><label class="label">Task Name: </label>${current.taskName}</p>
                <p><label class="label">Start Date: </label>${current.startDate}</p>
                <p><label class="label">End Date: </label>${current.endDate}</p>
                <p><label class="label">Severity: </label>${current.severity}</p>
                <p><label class="label">Description: </label>${current.description}</p>
            </div>
        </div>
    </body>
</html>