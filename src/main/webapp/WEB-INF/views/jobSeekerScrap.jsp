<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Job Seeker Scraps</title>
</head>
<body>
    <h1>Job Seeker Scraps</h1>
    <table>
        <tr>
            <th>Scrap ID</th>
            <th>Job Post ID</th>
            <th>Created Date</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${scraps}" var="scrap">
            <tr>
                <td>${scrap.scrapId}</td>
                <td>${scrap.jobPostId}</td>
                <td>${scrap.created}</td>
                <td>
                    <form action="/scrap/jobSeeker/delete" method="post">
                        <input type="hidden" name="scrapId" value="${scrap.scrapId}"/>
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form action="/scrap/jobSeeker/add" method="post">
        <input type="text" name="jobPostId" placeholder="Job Post ID"/>
        <button type="submit">Add Scrap</button>
    </form>
</body>
</html>
