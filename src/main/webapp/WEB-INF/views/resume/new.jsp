<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>New Resume</title>
</head>
<body>
    <h1>New Resume</h1>
    <form action="/resumes" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required>
        <br>
        <label for="jobSeekerId">Job Seeker ID:</label>
        <input type="text" id="jobSeekerId" name="jobSeekerId" required>
        <br>
        <label for="content">Content:</label>
        <textarea id="content" name="content" required></textarea>
        <br>
        <label for="education">Education:</label>
        <textarea id="education" name="education" required></textarea>
        <br>
        <label for="experience">Experience:</label>
        <textarea id="experience" name="experience" required></textarea>
        <br>
        <label for="link">Link:</label>
        <input type="text" id="link" name="link" required>
        <br>
        <label for="fileName">File Name:</label>
        <input type="text" id="fileName" name="fileName" required>
        <br>
        <label for="filePath">File Path:</label>
        <input type="text" id="filePath" name="filePath" required>
        <br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
