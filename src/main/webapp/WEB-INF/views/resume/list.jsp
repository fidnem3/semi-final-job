<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Resume List</title>
</head>
<body>
    <h1>Resume List</h1>
    <a href="resumes/new">New Resume</a>
    <table>
        <tr>
            <th>Title</th>
            <th>Job Seeker ID</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="resume" items="${resumes}">
            <tr>
                <td>${resume.title}</td>
                <td>${resume.jobSeekerId}</td>
                <td>
                    <a href="resumes/${resume.resumeId}">View</a>
                    <a href="resumes/${resume.resumeId}/edit">Edit</a>
                    <form action="resumes/${resume.resumeId}/delete" method="post" style="display:inline;">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
