
package com.mycompany.dataproject;



    public class LinkedList <T extends Comparable<T>> {
	 class Node<T>{
	        public T data;
	        public Node<T> next;
	        public Node () {
	            data = null;
	            next = null;
	        }
	        public Node (T val) {
	            data = val;
	            next = null;
	        }
	        // Setters/Getters...

	        public T getData() {
	            return data;
	        }

	        public void setData(T data) {
	            this.data = data;
	        }

	        public Node<T> getNext() {
	            return next;
	        }

	        public void setNext(Node<T> next) {
	            this.next = next;
	        }

	    }    


	    private Node<T> head;
	    private Node<T> current;
	    int size;
	    
	    public LinkedList () {
	        size = 0;
	        head = current = null;
	    }
            
            //
	    public boolean empty () {
	        return head == null;
	    }
	    public boolean last () {
	        return current.next == null;
	    }
	    public boolean full () {
	            return false;
	    }
	    public void findFirst () {
	            current = head;
	    }
	    public void findNext () {
	            current = current.next;
	    }
	    public T retrieve () {
	            return current.data;
	    }
	    public void update (T val) {
	            current.data = val;
	    }
            
	    
            // this method will insert the value in alphabetically order
	    public boolean insert (T val) {
	           
	            Node<T> tmp;
	            if (empty()) { 
	                    current = head = new Node (val);
	            }
	            else { 
	                if ( head.getData().compareTo(val) >0) // if the value is less than the head value, insert the new node as the new head
	                {
	                    tmp = new Node(val);
	                    tmp.setNext(head);
	                    head = tmp;
	                }
	                else
	                {
	                    Node<T> prev = null;
	                    current = head;
	                    
	                    while (( current != null ) && (current.getData().compareTo(val) <= 0))
	                    {
	                        prev = current;
	                        current = current.getNext();
	                    }
	                    tmp = new Node (val);
	                    if ( current != null)
	                    {
	                        tmp.next = current;
	                        prev.next = tmp;
	                        current = tmp;
	                    }
	                    else
	                        current = prev.next =tmp;
	                }
	            }
	            size++;
	            return true;
	    }

            // this method will search for the given value in the linkedlist
	    public boolean search (T val)
	    {
	        if (head == null)
	            return false;
	        
	        Node<T> node  = head;
	        while ((node != null) && (node.getData().compareTo(val) != 0))
	            node = node.getNext();
	        if ((node != null) && (node.getData().compareTo(val) == 0)) // if the value is found it will update the node
	        {
	            current = node;
	            return true;
	        }
	        return false;
	    }
	      
            // this method will remove the given value from the linked list
	    public T remove (T val) {
	            
	        if (search (val) == false)
	         return null;

	        T data = current.getData();
	        
	        if (current == head) { // if the given value is the head it will move the head to the next node
	                head = head.next;
	        }
	        else {
	                Node tmp = head;

	                while (tmp.next != current)
	                        tmp = tmp.next;
	               tmp.next = current.next;
	        }
	        if (current.next == null)
	                current = head;
	        else
	                current = current.next;
	        size -- ;
	        return data;    
	    }

	     @Override
	    public String toString() 
	    {
	           Node<T>  p = head;
	            String str = "" ;
	            
	            while ( p != null)
	            {
	                str += p.getData().toString();
	                str +=  "\n";
	                p = p .next;
	            }
	            return str;
	    }
	}

    

