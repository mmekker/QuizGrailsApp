<!DOCTYPE html>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html;charset=UTF-8'>
    <title>Trivia Game</title>
</head>
    <body>
        <h1>Home</h1>
        <a href="/logout">Logout</a>
        <br>
        <p>Hello, ${username}. Your password is  ${password}.</p>
        <font size="3" color="red">${score}</font>
        <form action="/quiz" method=GET>
            <br>
            Category:
            <select name="category">
                <g:each in="${categories}" var="cat">
                    <option value="${cat}" selected>${cat}</option>
                </g:each>
                <option value="any" selected>Any Category</option>
            </select>
            <br>
            Difficulty:
            <select name="difficulty">
                <option value="any" selected>Any</option>
                <option value="easy">Easy</option>
                <option value="medium">Medium</option>
                <option value="hard">Hard</option>
            </select>
            <br>
            <input type=submit value="Start Quiz">
        </form>
        <br><br>
        Question List:
        <g:each in="${questions}" var="question">
            <p>- Q: ${question.question}</p>
            <p>____A: ${question.answer}</p>
        </g:each>
    </body>
</html>