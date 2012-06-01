<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Servlet Hello World</title>
        <style>.error { color: red; } .success { color: green; }</style>
    </head>
    <body>
        <form method="post">
            <h1>Hello</h1>
            <p>
                <label for="name">What's your name?</label>
                <input id="name" name="name" value="${fn:escapeXml(param.name)}">
                <span class="error">${messages.name}</span>
            </p>
            <p>
                <label for="age">What's your age?</label>
                <input id="age" name="age" value="${fn:escapeXml(param.age)}">
                <span class="error">${messages.age}</span>
            </p>
            <p>
                <input type="submit">
                <span class="success">${messages.success}</span>
            </p>
        </form>
    </body>
</html>
