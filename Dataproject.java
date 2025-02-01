
package com.mycompany.dataproject;


public class Dataproject {
    
	public static void main(String[] args) {
        
	       System.out.println("Welcome to the BST phonebook! ");

	Phonebook p1 = new Phonebook();

	int key ;

	do{
	key = p1.Mainmenu();

	switch(key){
	    case 1 :
	        p1.AddContact();
	        break ;
	        
	    case 2 :
	        p1.SearchContact();
	        break ;
	        
	        
	    case 3 :
	        p1.DeleteContact() ;
	        break ;
	        
	    case 4 :
	        int choice = p1.schedulemenu() ;
	        
	        if(choice == 1)
	        p1.ScheduleEvent();
	        else
	        if(choice == 2)
	        p1.ScheduleAppoinment() ;    
	        break ;
	        
	    case 5 :    
	        p1.PrintEvent();
	        break;
	        
	    case 6 :
	        p1.PrintContactsFirstName() ;
	        break ;
	        
	    case 7 :    
	        p1.PrintAllEvents();
	        break ;
       
	}
	    


	}while(key != 8);

	}}   
