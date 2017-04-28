package quizappgrails

import domains.User

class BootStrap {

    def init = { servletContext ->
    	User u = new User()
    	u.username = "tu"
    	u.password = "tp"
    	u.save()
    }
    def destroy = {
    }
}
