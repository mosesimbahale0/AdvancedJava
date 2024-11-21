<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Preferences</title>
</head>
<body>
    <h1>Manage Preferences</h1>
    <form action="preferences" method="post">
        <label for="preferences">Preferences:</label>
        <input type="text" name="preferences" id="preferences" value="${preferences}">
        <button type="submit">Save</button>
    </form>
</body>
</html>
