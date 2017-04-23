package quizappgrails

class UrlMappings {

    static mappings = {
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
