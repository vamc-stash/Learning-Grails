package notes

class CustomerController {

	static scaffold = Customer

    // def index() { }
    def save = {

    	def customerInstance = new Customer(params)

    	//customerInstance.save flush:true, failOnError:true
    	customerInstance.save failOnError:true

    	//redirect action:"show", id: customerInstance.id
    	redirect(controller:"home", action:"signin")
    }

    def show = {
    	def customerInstance = Customer.get(params.id)
    	[customerInstance: customerInstance]
    }

}

