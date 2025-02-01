
package com.mycompany.dataproject;


public class Event implements Comparable<Event> {
	
		String title;
		String date;
	    String time;
	    String location;
	    boolean EventType;  // event true , appointment = false;
	    LinkedList <String> names = new LinkedList<String> ();;

	    public Event() {
	        this.title = "";
	        this.date = null;
	        this.time = "";
	        this.location = "";
	        this.EventType = true;
	        
	    }
	    
	    public Event(String title, String date, String time, String location, boolean t, String contact) {
	        this.title = title;
	        this.date =date ;
	        this.time = time;
	        this.location = location;
	        this.EventType =t;
	        this.names = new LinkedList<String> ();
	        names.insert( contact);
	    }
// THIS METHOD WILL ADDCONTACT TO EVENT LIST , BEFORE ADDING IT CHEACK THE TYPE IF IT'S EVENT(EventType; event true ) OR  appointment THEN 
	    //appointment = false; ALSO  CHEACK THE SIZE IT SHOULD  BE =0 SINCE ONLY 1 appointment FOR 1 contact , BUT THE EVENT CAN HAVE MANY AS WE CAN
	    public boolean addContact (String contact)
	    {
	        if ((this.EventType == true) || ((this.EventType == false)&&(names.size == 0)))
	            return names.insert(contact);
	        
	        System.out.println("Could not add more than contact for an appoinment");
	        return false;
	    }
	    
//This method will remove the contact from the contact that related to the event for example if we have event lunch and we have two contact R AND B
	    //IF WE WANT TO REMOVE R FROM THE EVENT AND DOES NOT EXIT ANY MORE WILL USE THIS METHOD
	    public boolean removeContact(String contact)
	    {
	            String name = names.remove(contact);
	            if ( name != null)
	                return true; 
	            return false;
	    }
	 
	    @Override
	    public String toString() {
	        String EventT = (this.EventType == true)? "Event ": "Appoinment ";     
	        String str = "\n" + EventT + " title: " + title +
	                    "\n " + EventT + "  date and time (MM/DD/YYYY HH:MM): " + date + time +
	                   "\n" + EventT + " location: " + location +
	                   "\nType: " + EventT +
	                    "\nContacts names:   \n" + names.toString();
	                
	          return str;
	    }
	    
	    
	    @Override
	    public int compareTo(Event obj) {
	        
	            return (this.title.compareToIgnoreCase(obj.title));}
	        

	    
	    


	    



	}


