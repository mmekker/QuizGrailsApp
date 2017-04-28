package quizappgrails

import domains.User
import domains.Question
import groovy.json.JsonSlurper


class ApplicationController {


    def landing() {
        render(view: 'login')
    }

    def login(String username, String password) {
    	User u = User.findByUsername(username)

    	if(u != null && u.password.equals(password)) {
            session.setAttribute("username", u.username)
    		def questions = u.questions.asList()
            def categories = getCategories()
            def model = [username: username, password: password, questions: questions, score: "", categories: categories]
			render(view: "home", model: model)
    	}
    	else {
    		redirect(uri: "/")
    	}
    }

    def register(String username, String password, String password2) {
    	User u = User.findByUsername(username)
    	if(u == null && password.equals(password2)) {
    		u = new User()
    		u.username = username
    		u.password = password
    		u.save()
    		session.setAttribute("username", u.username)
            def categories = getCategories()
            def model = [username: username, password: password, score: "", categories: categories]
            def questions = u.questions
            if(questions!=null) model.push(questions: questions)
			render(view: "home", model: model)
    	}
        else {
            redirect(uri: "/")
        }
    }

    def logout() {
        session.invalidate()
        redirect(uri: "/")
    }

    def quiz(String category, String difficulty) {
        def questions = getQuestions(category,difficulty)
        def model = [questions: questions]
        render(view: "quiz", model: model)
    }

    def checkQuiz(boolean q0, boolean q1, boolean q2, boolean q3, boolean q4, 
                    boolean qs0, boolean qs1, boolean qs2, boolean qs3, boolean qs4, 
                    String question0, String question1, String question2, String question3, String question4, 
                    String answer0, String answer1, String answer2, String answer3, String answer4
                    ) {
        int score = 0
        if(q0) score++
        if(q1) score++
        if(q2) score++
        if(q3) score++
        if(q4) score++
        def username = session.getAttribute("username")
        User u = User.findByUsername(username)
        if(u != null) {
            if(qs0) {
                if(Question.findByQuestion(question1) == null) {
                    Question q = new Question();
                    q.question = question0
                    q.answer = answer0
                    q.user = u
                    q.save()
                    u.questions.add(q)
                }
            }
            if(qs1) {
                if(Question.findByQuestion(question1) == null) {
                    Question q = new Question();
                    q.question = question1
                    q.answer = answer1
                    q.user = u
                    q.save()
                    u.questions.add(q)
                }
            }
            if(qs2) {
                if(Question.findByQuestion(question1) == null) {
                    Question q = new Question();
                    q.question = question2
                    q.answer = answer2
                    q.user = u
                    q.save()
                    println q
                    u.questions.add(q)
                }
            }
            if(qs3) {
                if(Question.findByQuestion(question1) == null) {
                    Question q = new Question();
                    q.question = question3
                    q.answer = answer3
                    q.user = u
                    q.save()
                    u.questions.add(q)
                }
            }
            if(qs4) {
                if(Question.findByQuestion(question1) == null) {
                    Question q = new Question();
                    q.question = question4
                    q.answer = answer4
                    q.user = u
                    q.save()
                    u.questions.add(q)
                }
            }
            u.save()

            def categories = getCategories()
            def model = [username: u.username, password: u.password, score: "", categories: categories, questions: u.questions]
            render(view: "home", model: model)
        }
        else {
            render(view: "home", model: [categories: getCategories()])
        }
    }



    /*****HELPER METHODS*****/
    def getCategories() {
        String apiString = "https://opentdb.com/api_category.php"
        URL apiUrl = new URL(apiString)
        def categories = new JsonSlurper().parseText(apiUrl.text)
        ArrayList<String> cats = new ArrayList<String>()
        def list = categories.trivia_categories
        for(def x = 0; x < list.size(); x++) {
            cats.add(list[x].name)
        }
        return cats
    }

    def getCategoryId(String name) {
        String apiString = "https://opentdb.com/api_category.php"
        URL apiUrl = new URL(apiString)
        def categories = new JsonSlurper().parseText(apiUrl.text)
        def list = categories.trivia_categories
        def id = 0
        for(def x = 0; x < list.size(); x++) {
            if(list[x].name.equals(name)) {
                id = list[x].id
                break
            }
        }
        return id
    }

    def getQuestions(String category, String difficulty) {
        def diff = ""
        if(!difficulty.equals("any")) {
            diff = "&difficulty=" + difficulty
        }
        def cat = ""
        def catId = getCategoryId(category)
        if(!category.equals("any")) {
            cat = "&category=" + catId
        }
        String apiString = "https://opentdb.com/api.php?amount=5" + cat + diff + "&type=multiple"
        URL apiUrl = new URL(apiString)
        def questions = new JsonSlurper().parseText(apiUrl.text)
        return questions
    }
}