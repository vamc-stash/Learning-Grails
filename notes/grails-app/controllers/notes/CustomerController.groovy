package notes

class CustomerController {

	// static scaffold = Customer

    // def index() { }
    def save = {

        def customerInstance = Customer.findByEmail(params.email)
        if(customerInstance == null){

            customerInstance = new Customer(params)
            customerInstance.save failOnError:true
            redirect(controller:"home", action:"signin")
        }
        else{
            flash.message = "Email Address Already Exists!!"
            redirect(controller:'home', action:'signup')
        }
    	
    }

    def show = {
    	def customerInstance = Customer.get(params.id)
    	[customerInstance: customerInstance]
    }

}

