package quizappgrails

import domains.User

class BootStrap {

    def init = { servletContext ->
    	User u = new User()
    	u.username = "TestUsername"
    	u.password = "TestPassword"
    	u.save()
    }
    def destroy = {
    }
}
