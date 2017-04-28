package quizappgrails

class UrlMappings {

    static mappings = {
        /* Views mapping */
        "/"(controller: 'application', action: 'landing')
        "/login"(controller: 'application', action: 'login')
        "/register"(controller: 'application', action: 'register')
        "/logout"(controller: 'application', action: 'logout')
        "/home"(controller: 'application', action: 'home')
        "/quiz"(controller: 'application', action: 'quiz')
        "/checkQuiz"(controller: 'application', action: 'checkQuiz')


        /* API endpoints mapping */
        group "/api/users", {
            "/"(controller: 'users', action: 'GetAllUsers', method : 'get')
            "/$uId"(controller: 'users', action: 'getUserById', method : 'get')
            "/"(controller: 'users', action: 'createUser', method : 'post')
            "/$uId"(controller: 'users', action: 'updateUser', method : 'put')
            "/$uId"(controller: 'users', action: 'deleteUser', method : 'delete')
        }
        group "/api/question", {
            "/$qId"(controller: 'questions', action: 'getQuestionById', method: 'get')
            "/$uId"(controller: 'questions', action: 'postQuestionToUserId', method: 'post')
            "/$qId"(controller: 'questions', action: 'deleteQuestionById', method: 'delete')
        }
    }
}
