package notes

class RecordController {

	static scaffold = Record

	def save = {

		def customerInstance = Customer.get(session['user'].id)
		def recordInstance = new Record(notename:params.notename, notes:params.notes, customer:customerInstance)

		recordInstance.save(failOnError:true)
		redirect(controller:"home", action:'welcome')		

	}

	def show = {
    	// def recordInstance = Record.get(params.id)
    	// [recordInstance: recordInstance]
    	redirect(controller:"home", action:'welcome')
    }

   def update = {
    	def recordInstance = Record.get(params.id)
    	recordInstance.properties = params

    	try {
    		recordInstance.save(insert:false, failOnError:true)
    		redirect(action:'show', id:recordInstance.id)	
			}
			catch (Exception e) {
			    // deal with exception
			    render e
		}
    	//redirect(controller:"home", action:'welcome')	
    	
    }

    
    //def index() { }
}
