package notes

class HomeController {

    def index() { 
    	render(view: 'home')
    }

    def signup(){
    	render(view: 'signup')
    }

    def signin(){
    	render(view: 'signin')
    }

    def welcome(){

        if(session.user == null){
            def customerInstance = Customer.findByEmail(params.email)
            if(customerInstance == null || customerInstance.password != params.password){
                redirect(action:'signin')
            }
            else{
                session["user"] = customerInstance
                def records = Record.findAll()
                [user:customerInstance, records: records]
            }
        }
        else{
            def customerInstance = session["user"] 
            def lastSavedNote = Record.last()
            def records = Record.findAll()

            [user:customerInstance, lastSavedNote:lastSavedNote, records: records]
        }
    }
}
