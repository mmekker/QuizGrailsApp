<!DOCTYPE html>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html;charset=UTF-8'>
    <title>Trivia Game</title>
</head>
<body>
<h1>Quiz</h1>


    
<form action="/checkQuiz" method=GET>
	<g:set var="questionIndex" value="${0}" />
	<g:each in="${questions.results}" var="question">
		<g:set var="rnd" value="${(int)(Math.random()*3)}" />
		<g:set var="answerIndex" value="${0}" />
	    <fieldset id="q${questionIndex}"\>
	    	<p>${question.question}</p>
			<g:while test="${answerIndex < 3 }">
			    <g:if test="${answerIndex == rnd}">
				   <%rnd = -1%>
				   <%answerIndex--%>
				   <input type="radio" name="q${questionIndex}" value="true" id="q${questionIndex}c"\>${question.correct_answer}
				</g:if>
				<g:else>
				   <input type="radio" name="q${questionIndex}" value="false"\>${question.incorrect_answers[answerIndex]}
				</g:else>
			    <%answerIndex++%>
			</g:while>
	    </fieldset>
        <input type="hidden" name="question${questionIndex}" value="${question.question}">
        <input type="hidden" name="answer${questionIndex}" value="${question.correct_answer}">
        <input type="checkbox" name="qs${questionIndex}"> Save? <br><br>
		<%questionIndex++%>
	</g:each>
    <br><input type=submit value="Submit Quiz">
</form>
</body>
</html>