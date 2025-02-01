
package com.mycompany.dataproject;

import java.util.Scanner;
public class Contact implements Comparable<Contact> {

		String name;
	    String phonenumber;
	    String emailaddress;
	    String address;
	    String birthday; 
	    String notes;
	    LinkedList<Event> events = new LinkedList<Event>();// the contact that have many event//and Appointment
		public Contact(String name, String phonenumber, String emailaddress, String address, String birthday, String notes
				) {
			
			this.name = name;
			this.phonenumber = phonenumber;
			this.emailaddress = emailaddress;
			this.address = address;
			this.birthday = birthday;
			this.notes = notes;
			
		}

	    public Contact() {
	         this.name = "";
				this.phonenumber = "";
				this.emailaddress = "";
				this.address = "";
				this.birthday = "";
				this.notes = "";
	    }

		//copy construcoter 
			public Contact (Contact A) {
				this.name = A.name;
		        this.phonenumber = A.phonenumber;
		        this.emailaddress = A.emailaddress;
		        this.address = A.address;
		        this.birthday = A.birthday;
		        this.notes = A.notes;
				
			}
			
			
	    //THIS METHOD WILL ADD AN EVENT TO EVENT LIST FOR THE CONTACT AND Before ADDING IT Check IF THERE IS Conflict WITH ANOTHER EVENT IN LIST  Before ADDING THEM
	    //BY Checking the time and the date IF IT'S Exist before the list it will nOT added TO THE LIST OTHERWISE TRUE
			public boolean addEvent( Event e)

		        {
		                if (! events.empty())
		                { 
		                    events.findFirst();
		                    for ( int i = 0 ; i < events.size ; i++)
		                    {
		                        if ((events.retrieve().date.compareTo(e.date) == 0) 
		                                && (events.retrieve().time.compareTo(e.time) == 0))
		                            return false;
		                    }
		              }
		            events.insert(e);
		            return true;
		        }
			//THIS METHOD WILL removeEvent FROM EVENT LIST FOR THE CONTACT BY CHECKING THE Title OF THE EVENT (Search the title IF It is exist it will be removed)

			public boolean removeEvent( String Title)
		    {
				 Event E = new Event();//since our search method Receive an object for searching
			       E.title = Title; 
		        if (events.empty())
		            return false;
		      
		        if (events.search(E))
		        {
		            events.remove(E);
		            return true;
		        }
		        return false;
		    }
			//the next method are needing for BST CLASS when we are searching about specific data It THEY COMPARE IT WITH THE DATA RECEIVED TO CHECK IF THE RETURN VALUE IS ZERO THAT'S MEAN THE SAME DATA SENT IT EXIST BEFORE IN THE BST
			public int compareTo(Contact o) {
				return (this.name.compareToIgnoreCase(o.name));
			}
			public int compareTo(String C, int N) {
				
				
				if(N==1)
					return (this.phonenumber.compareToIgnoreCase(C));
				else if(N==2)
					 return (this.emailaddress.compareToIgnoreCase(C));
				else if(N==3)
						 return (this.address.compareToIgnoreCase(C));
				else if(N==4)
						 return (this.birthday.compareTo(C) ) ;
				else
				return -1;
				

			}
	    //This method will be  return first name it will receive a string to AND split THE STRING THEN Put it in string array AFYER THAT return THE VALUE AT INDEX 0
	    
			 public int compareFirstName(String name) {
			        try {
			            String [] FirstName = this.name.split(" ");
			            return (FirstName[0].compareToIgnoreCase(name) ) ;
			        }
			        catch (Exception e)
			        {
			            throw new UnsupportedOperationException("ERROR");
			        }
			    }

	    
			 public String toString() {
			        return "\nName: " + name + "\nPhone Number: " + phonenumber + "\nEmail Address: " + emailaddress + "\nAddress: " +  address + "\nBirthday: " + birthday + "\nNotes: " + notes ;

			    }


			public String getName() {
				return name;
			}


			public void setName(String name) {
				this.name = name;
			}


			public String getPhonenumber() {
				return phonenumber;
			}


			public void setPhonenumber(String phonenumber) {
				this.phonenumber = phonenumber;
			}


			public String getEmailaddress() {
				return emailaddress;
			}


			public void setEmailaddress(String emailaddress) {
				this.emailaddress = emailaddress;
			}


			public String getAddress() {
				return address;
			}


			public void setAddress(String address) {
				this.address = address;
			}


			public String getBirthday() {
				return birthday;
			}


			public void setBirthday(String birthday) {
				this.birthday = birthday;
			}


			public String getNotes() {
				return notes;
			}


			public void setNotes(String notes) {
				this.notes = notes;
			}


			public LinkedList<Event> getEvents() {
				return events;
			}


			public void setEvents(LinkedList<Event> events) {
				this.events = events;
			}

	    public void display() {
			System.out.print("\nName: " + name +
	                    "\nPhone Number: " + phonenumber +
	                    "\nEmail Address: " + emailaddress +
	                    "\nAddress: " +  address +
	                    "\nBirthday: " + birthday +
	                    "\nNotes: " + notes + "\n" );
			
		}
	    
	   
	    
	    
	    
	}
