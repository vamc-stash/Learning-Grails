package notes

class BootStrap {

    def init = { servletContext ->

    	new notes.Customer(name:"RANGA VAMSI", email:"rangavamsi5@gmail.com", password:"asdfASDF1234").save()
    }
    def destroy = {
    }
}
