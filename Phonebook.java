
package com.mycompany.dataproject;

import java.util.Scanner;

public class Phonebook {
    
public static Scanner input = new Scanner(System.in);

 public static BST contactsBST ;
 public static LinkedList<Event> event ;


    public Phonebook() {
        contactsBST = new BST() ;
        event = new LinkedList<Event>();
    }

//THIS METHOD WILL ADD THE CONTACT TO contactsBST BUT BEFORE ADDING IT CHECK THE NAME AND PHONE NUMBER SINCE THEY ARE UNIQUE BY CALLING THE METHOD IN CLASS BST
    
    public static void AddContact(){
        Contact c = new Contact();
        System.out.println("Enter the contact\'s name: ");
        input.nextLine();
        c.name = input.nextLine();
        
        if (!contactsBST.empty() && contactsBST.findkey(c.name))
        {
                System.out.println("Contact found!, the name should be uniq");
                return;
        }
        System.out.println("Enter the contact's phone number:");
        c.phonenumber = input.nextLine();
        while (c.phonenumber.length()<10 || c.phonenumber.length()!=10) {
			  System.out.println("WRONG PHONE"); 
			  System.out.println("\"Enter the contact's phone number"); 
			  c.phonenumber =input.nextLine();
		}
        
        if (!contactsBST.empty() && (contactsBST.SearchPhone(c.phonenumber)))
        {
            System.out.println("phone number found!,the phone should be Unique");
            return;
        }
        System.out.println("Enter the contact's email address: ");
        c.emailaddress = input.nextLine();
        int VA=c.emailaddress.indexOf("@");
        while (VA==-1) {
			  System.out.println("WRONG EMAIL"); 
			  System.out.println("Enter the contact's email address:"); 
			  c.emailaddress=input.nextLine();
                          VA=c.emailaddress.indexOf("@");
		}
        System.out.println("Enter the contact's address: ");
        c.address = input.nextLine();
        
        System.out.println("Enter the contact's birthday: ");
        c.birthday = input.nextLine();
        
        String[] parts = c.birthday.split("/");
int year, month, day;

            day = Integer.parseInt(parts[0]);
            month = Integer.parseInt(parts[1]);
            year = Integer.parseInt(parts[2]);
            
        while (parts.length != 3){
            System.out.println("Invalid birthday format! please try again!");
            System.out.println("Enter the contact's birthday: ");
            c.birthday = input.nextLine();
        }
        
     
        while (year < 0 || month < 1 || month > 12 || day < 1 || day > 31) {
          System.out.println("Invalid birthday format! please try again");
          System.out.println("Enter the contact's birthday: ");
            c.birthday = input.nextLine();  
            parts = c.birthday.split("/");
            day = Integer.parseInt(parts[0]);
            month = Integer.parseInt(parts[1]);
            year = Integer.parseInt(parts[2]);
        }
  
        System.out.println("Enter any notes for the contact: ");
        c.notes = input.nextLine();
        
        if (contactsBST.insert(c.name, c))
            System.out.println("Contact added successfully!");
    }


    //This method will search about the contact IN contactsBST IF IT'S EXIT OR NOT
    
    public static void SearchContact()
    {
        int choice = searchContactmenu();
        if (contactsBST.empty())
            System.out.println("Contact has not been found!");
        else
        {
            switch ( choice )
           {
               case 1:
               {
                    System.out.print("Enter the contact's name: ");
                    input.nextLine();
                    String name = input.nextLine();
                    
                    if (!contactsBST.empty() && contactsBST.findkey(name))
                    {
                        System.out.println("Contact found!");
                        System.out.println(contactsBST.retrieve());//.toString()
                        break;
                    }
                    System.out.println("Contact has not been found!");
               }
               break;

               case 2:
               {
                   System.out.print("Enter the contact's phone number:");
                   input.nextLine();
                    String phonenumber = input.nextLine();
                   
                    if (!contactsBST.empty() && contactsBST.SearchPhone(phonenumber))
                    {
                        System.out.println("Contact has been found!");
                        System.out.println(contactsBST.retrieve());
                        break;
                    }
                    System.out.println("Contact has not been found!");
               }
               break;

               case 3:
               {
                   System.out.print("Enter the contact's email address: ");
                   input.nextLine();
                    String email = input.nextLine();
                   
                    if (!contactsBST.empty())
                    {
                        contactsBST.SearchEmail(email);
                        
                        break;
                    }
                  System.out.println("Contact has not been found!");  
               }                
               break;

               case 4:
               {
                   System.out.print("Enter the contact's address: ");
                   input.nextLine();
                    String address = input.nextLine();
                    if (!contactsBST.empty() )
                    {
                        contactsBST.SearchAddress(address);
                        System.out.println("Contact has been found!");
                        break;
                    }
                    System.out.println("Contact has not been found!");
               }                
               break;

               case 5:
               {
                   System.out.print("Enter the contact's Birthday: ");
                   input.nextLine();
                   String birthday = input.nextLine();
                    if (!contactsBST.empty() )
                    {
                        contactsBST.SearchBirthday(birthday);
                        System.out.println("Contact has been found!");
                        break;
                    }
                    System.out.println("Contacts has not been found!");
               }
           }
        }            
    }
    
    //With this method will delete the contact from the PST list also it will delete the contact from event list in phonebook and event class
    
    public static void DeleteContact()
    {
        
        
        Contact c = new Contact();
        
        System.out.print("Enter the contact's name: ");
        input.nextLine();
        c.name = input.nextLine();
       
        if (contactsBST.empty())
            System.out.println("Contact has not been found!");
        else
        {
            
            if ( ! contactsBST.findkey(c.name))
                System.out.println("Contact has not been found!");
            else
            {
                c = contactsBST.retrieve();
                contactsBST.removeKey(c.name);
                
                
                if (! c.events.empty()) // deleting the Contact from the event list
                {
                    c.events.findFirst();
                    for ( int i = 0 ; i < c.events.size ; i++)
                    {
                        Event e = c.events.retrieve();
                        if ( (!event.empty()) && event.search(e) && (event.retrieve().date.compareTo(e.date)==0) && (event.retrieve().time.compareTo(e.time)==0) && (event.retrieve().location.compareTo(e.location)==0) && (event.retrieve().EventType== e.EventType))
                        {
                            Event Update = event.retrieve();
                            
                            Update.removeContact(c.name);
                            if (Update.names.empty()) // if the contact was the last one in the event , the event will deleted
                            {
                                event.remove(e);
                                System.out.println(" The Event was Deleted");
                            }
                            else
                                event.update(Update);
                            
                        }
                        c.events.findNext();
                    }
                }
                System.out.println("Contact has been Deleted Successfully !");
                System.out.println(c);
            }    
        }        
    }
    

   
   //The method uses a binary search tree (BST) to manage contacts and an event list for managing events. It also checks for conflicts with existing events and ensures the event is associated with the specified contacts.
public static void ScheduleEvent()
    {
        Contact c = new Contact();
        Event e = new Event();
        
        boolean Updated = false;
        boolean EventContact = false;
        
            String type = "Event";
            e.EventType = true;
            System.out.print("Enter event title: ");
            input.nextLine();
            e.title = input.nextLine();
            
            System.out.print("Enter contacts name separated by a comma: ");
            String line = input.nextLine();
            String [] names = line.split(",");
            

            
            System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
            e.date = input.next();

            e.time = input.next();

            System.out.print("Enter event location: ");
            input.nextLine();
            e.location = input.nextLine();
            for ( int i = 0 ; i < names.length ; i++){    
                c.name = names[i];

        
                if ( ! contactsBST.empty() && contactsBST.findkey(c.name) == true)
                {
  
                    c = contactsBST.retrieve();
                   
                    
                        // event added to contact
                       
                        if ( (!event.empty()) && event.search(e) && (event.retrieve().date.compareTo(e.date)==0) && (event.retrieve().time.compareTo(e.time)==0)&& (event.retrieve().location.compareTo(e.location)==0)&& (event.retrieve().EventType== e.EventType))
                        {
                            EventContact = c.addEvent(e);
                            Event eventFound = event.retrieve();
                            eventFound.names.insert(c.name);
                            Updated = true;
                        }
                        else{
            
                
                	
                	if (! event.empty())
	                { 
	                    event.findFirst();
	                    for ( int I = 0 ; I < event.size ; I++)
	                    {
	                        if ((event.retrieve().date.compareTo(e.date) == 0) 
	                                && (event.retrieve().time.compareTo(e.time) == 0)) {
	                        	System.out.println("Contact has conflict with Event or Appoinment !  ");
                              break ;
                                }
                      event.findNext();
                	} 
                        }
                        else{
                        if (! Updated)  
                        {
                        EventContact = c.addEvent(e);
                        e.names.insert(c.name);
                        event.insert(e);  }
                       System.out.println("Event scheduled successfully ! ");
                        }
                        
                    }
                }
                else
                    System.out.println("Contcat " + c.name + " not found !");   }                                

    }

//The method uses a binary search tree (BST) to manage contacts and an event list for managing events and appointments.
// the method Associates the appointment with the specified contact and checks for conflicts with existing events or appointments. If no conflicts are found, the appointment is scheduled successfully
public static void ScheduleAppoinment(){
   Contact c = new Contact();
        Event e = new Event();
        
        boolean Updated = false;
        boolean EventContact = false;
        
       
        
      String type = "Appoinment";
            e.EventType = false;
            
            System.out.print("Enter Appoinment title: ");
            input.nextLine();
            e.title = input.nextLine();
        
            System.out.print("Enter contact name: ");
            c.name = input.nextLine();
       
                
                System.out.print("Enter Appoinment date and time (MM/DD/YYYY HH:MM): ");
                e.date = input.next();
                e.time = input.next();

                System.out.print("Enter Appoinment location: ");
                input.nextLine();
                e.location = input.nextLine();

                if ( ! contactsBST.empty() && contactsBST.findkey(c.name) == true)
                {
                	c = contactsBST.retrieve();
                        
                	if (! event.empty())
	                { 
	                    event.findFirst();
	                    for ( int I = 0 ; I < event.size ; I++)
	                    {
	                        if ((event.retrieve().date.compareTo(e.date) == 0) 
	                                && (event.retrieve().time.compareTo(e.time) == 0)) {
	                        	System.out.println("Contact has conflict with Event or Appoinment !  ");
                                        Updated = true;
                                        break;
                                }
                       event.findNext();
                	}
                            
                        }
      
                    EventContact = c.addEvent(e);
                    if (EventContact)
                    {
        
                        if ( (!event.empty()) && event.search(e) && (event.retrieve().date.compareTo(e.date)==0) && (event.retrieve().time.compareTo(e.time)==0)&& (event.retrieve().location.compareTo(e.location)==0)&& (event.retrieve().EventType== e.EventType))
                        {
                            Event eventFound = event.retrieve();
                            eventFound.names.insert(c.name);
                           Updated = true;
                        }

                        
                        if (! Updated)  
                        {      
                         e.names.insert(c.name);
                         event.insert(e);  
                        System.out.println("Appoinment scheduled successfully!   ");	
                        }
                                }  
      
                }
                else
                    System.out.println("Contcat " + c.name + " not found !");   }               
            
                
               
    


   
 // this method will either print the event from the contact name or from the event title  
public static void PrintEvent(){
        int choice = searchEventmenu();
        switch ( choice )
        {
             case 1:
	            {
	                Contact c = new Contact();
	                System.out.print("Enter the contact name :  ");
	                input.nextLine();
	                c.name = input.nextLine();
	                        
	                if (! contactsBST.empty() )
	                {
	                  if (contactsBST.findkey(c.name) == true)
	                  {
	                    System.out.println("Contact found !");
	                    c = contactsBST.retrieve();

	                    c.events.findFirst();
	                    for (int i = 0 ; i < c.events.size ; i++)
	                    { System.out.println();
	                        Event e = c.events.retrieve();
	                        if (!event.empty() && event.search(e) 
	                                && (event.retrieve().date.compareTo(e.date)==0) 
	                                && (event.retrieve().time.compareTo(e.time)==0)
	                                && (event.retrieve().location.compareTo(e.location)==0)
	                                && (event.retrieve().EventType== e.EventType)) 
	                            System.out.println(event.retrieve().toString());  c.events.findNext();
	                        
	                       
	                    }
	                    if (c.events.empty())
	                        System.out.println("No events found for this contact !");
	                     }
	                else
	                    System.out.println("Contact not found !");
	                }
	                else
	                    System.out.println("Contact not found !");
	            }
	            break;

            case 2:
            {
                Event e = new Event();
                System.out.print("Enter the event title:  ");
                input.nextLine();
                e.title = input.nextLine();
                
               if (! event.empty())
                {
                    event.findFirst();
                    for (int i = 0 ; i < event.size ; i++)
                    {   
                        if (event.retrieve().compareTo(e) == 0)
                        {
                            if (event.retrieve().EventType == true)
                                System.out.println("Event found!");
                            else
                                System.out.println("Appoinment found!");
                            
                            Event ee = event.retrieve();
                            System.out.println(ee);
                        }
                        event.findNext();
                    }
                }
                else
                    System.out.println("Event/Appoinment not found !");
            }
            break;
        }
    }


// this method will print all the events (we already inserted the events alphabetically)
public static void PrintAllEvents(){
        if (!event.empty())
            System.out.println(event.toString());
        else
            System.out.println("No events found !");
}

// this method will print all the contact that share the first name
  public static void PrintContactsFirstName(){
       
        System.out.print("Enter the first name:");
       String name = input.next();
        
        if (contactsBST.empty())
            System.out.println("No Contacts found !");
        else
            contactsBST.SearchSameFirstName(name);
    }
  
  
  // project interface
  
    public static int Mainmenu(){ 
        
System.out.println("pleace choose an option:");
System.out.println("1. Add contact");
System.out.println("2. search for a contact");
System.out.println("3. delete a contact");
System.out.println("4. schedulean an event/appointment");
System.out.println("5. print event details");
System.out.println("6. print all contacts by first name");
System.out.println("7. print all event alphabetically");
System.out.println("8. Exit");
int key = input.nextInt();

return key ;
    }

    
    public static int searchContactmenu()
    {
        System.out.println("Enter search criteria:");
        System.out.println("1. Name");
        System.out.println("2. Phone Number");
        System.out.println("3. Email Address");
        System.out.println("4. Address");
        System.out.println("5. Birthday");
        System.out.println("\nEnter your choice: ");
        int key = input.nextInt();
        return key;
    }

    public static int searchEventmenu()
    {
        System.out.println("Enter search criteria:");
        System.out.println("1. contact name");
        System.out.println("2. Event tittle");
        System.out.println("\nEnter your choice: ");
        int key = input.nextInt();
        return key;
    }

    public static int schedulemenu()
    {
        System.out.println("Enter type:");
        System.out.println("1. event");
        System.out.println("2. appointment");
        System.out.println("\nEnter your choice: ");
        int key = input.nextInt();
        return key;
    }
       
       
   }
  

