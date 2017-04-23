package domains;
import grails.rest.*

@Resource(uri='/api/users')
class User {
	String username
	String password

	static hasMany = [questions: Question]

	static constraints = {
        username blank: false, unique: true
        password blank: false
    }
}