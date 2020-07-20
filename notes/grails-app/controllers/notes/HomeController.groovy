package notes

class HomeController {

    def index = { 
    	render(view: 'home')
    }

    def signup = {
    	render(view: 'signup')
    }

    def signin = {
    	render(view: 'signin')
    }

    def welcome = {

        if(session.user == null){
            def customerInstance = Customer.findByEmail(params.email)
            if(customerInstance == null || customerInstance.password != params.password){
                flash.message = "!!!!  Incorrect Credentials"
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

    def save = {

        def customerInstance = Customer.get(session['user'].id)

        def recordInstance = Record.findByNotename(params.notename)
        if(recordInstance == null){
            recordInstance = new Record(notename:params.notename, notes:params.notes, customer:customerInstance)

            try{
                recordInstance.save(failOnError:true)
                render(view:'welcome', model:[user:session["user"], lastSavedNote:recordInstance, records:Record.findAll()])  
            }catch(Exception e){
                render e
            }
            
        }
        else{
            flash.error = "Note with same filename already exists!"
            render(view:'welcome', model:[user:session["user"], lastSavedNote:params, records:Record.findAll(), fileNameError: true])
        }

    }

    def edit = {
        if(session.user != null){
            def recordInstance = Record.get(params.id)
            render(view:'welcome', model:[user:session["user"], lastSavedNote:recordInstance, records:Record.findAll()])
        }
        else{
            redirect(action:'signin')
        }
    }

    def update = {

        def recordInstance = Record.get(params.id)

        recordInstance.notename = params.notename
        recordInstance.notes = params.notes

        try {
            recordInstance.save(failOnError:true)
            render(view:'welcome', model:[user:session["user"], lastSavedNote:recordInstance, records:Record.findAll()])    
        }catch (Exception e) {
            // deal with exception
            render e
        }
        //redirect(controller:"home", action:'welcome') 
    }

    def signout = {
        session.invalidate()
        redirect(action:"")
    }
}
