package notes

class Record {

	String notename
	String notes
	static belongsTo = [customer:Customer]

    static constraints = {
    	notename(unique:true)
    	notes(nullable:true)
	    }
}
