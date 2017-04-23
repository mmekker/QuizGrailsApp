package domains;
import grails.rest.*

@Resource(uri='/api/questions')
class Question {
	String question
	String answer

    static belongsTo = [user: User]
    
	static constraints = {
        question blank: false
        answer blank: false
    }
}