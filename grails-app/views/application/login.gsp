<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv='Content-Type' content='text/html;charset=UTF-8'>
        <title>Trivia Game</title>
    </head>
    <body>
        <!--<font size="3" color="red">@message</font>-->
        <h1>Login</h1>
        <div id="login">
            <form action="/login" method=GET>
                <br>
                Name:
                <input type=text size=20 name=username>
                <br>
                Password:
                <input type=text size=20 name=password>
                <br>
                <input type=submit value="Login">
            </form>
        </div>
        <br>
        <div id="register">
            <form action="/register" method=GET>
                <br>
                Name:
                <input type=text size=20 name=username>
                <br>
                Password:
                <input type=text size=20 name=password>
                <br>
                Retype Password:
                <input type=text size=20 name=password2>
                <br>
                <input type=submit value="Register">
            </form>
        </div>
    </body>
</html>