
package com.mycompany.dataproject;
public class BST {
	
		 BSTNode root, current;
		 public BST() {
	         root = current = null;
	 }

		 public boolean empty() {
	         return root == null;
	 }

		 public boolean full() {
	         return false;
	 }

		    public  Contact retrieve () {
		            return current.data;
		    }

		    public boolean findkey(String Skey) {
	            BSTNode p = root;
	            BSTNode  q = root;

	            if(empty())
	                    return false;

	            while(p != null) {
	                    q = p;
	                    if(p.key.compareTo(Skey) == 0) {
	                            current = p;
	                            return true;
	                    }
	                    else if(Skey.compareTo(p.key) < 0)
	                            p = p.left;
	                    else
	                    	if(Skey.compareTo(p.key) > 0)///R
	                            p = p.right;
	            }
	            current = q;
	            return false;
	    }
		    //THIS METHOD WILL INSERT THE NAME OF THE CONTACT ALPHABETIC BY CHECKING THE KEYS ALSO IT WILL SEARCH ABOUT THE NAME IF IT EXISTS BEFORE IT WILL NOT BE ADDING SINCE THE NAME SHOULD BE UNIQUE

		    public boolean insert(String k, Contact val) {
	            BSTNode  p;
	            BSTNode q = current;
	            p = new BSTNode (k, val);

	            if(findkey(k)) {
	                    current = q;  // findkey() modified current
	                    return false; // key already in the BST and it should be Unique
	            }

	            
	            if (empty()) {
	                    root = current = p;
	                    return true;
	            }
	            else {
	                    // current is pointing to parent of the new key///BACKK
	                    if (k.compareTo(current.key) < 0)
	                            current.left = p;
	                    else
	                            current.right = p;
	                    current = p;
	                    return true;
	            }
	    }
		    //This method would remove the key from the BST LIST BY RECEIVING NAME
		    public boolean removeKey(String k) {
		        // Search 
		    	String k1 = k;      
		        BSTNode p = root;      
		        BSTNode q = null;    // Parent of p
		        
		        while (p != null) 
		        {
		            if (k1.compareTo(p.key) <0) 
		            {
		                q =p;
		                p = p.left;
		            }
		            else if (k1.compareTo(p.key) >0) 
		            {
		                q = p;
		                p = p.right;
		            } 
		            else { 
		                // Found the key            
		                // Check the three cases
		                if ((p.left != null) && (p.right != null)) 
		                { 
		    	// Case 3: two children
		             	 
		                	
		                        // Search for the min in the right subtree
		                BSTNode min = p.right;
		               q = p;
		                        while (min.left != null) 
		                        {
		                            q = min;
		                            min = min.left;
		                        }
		                        p.key = min.key;               
		                        p.data = min.data;
		                        k1 = min.key;
		                        p = min;
		                        // Now fall back to either case 1 or 2
		                }
		                // The subtree rooted at p will change here            
		                if (p.left != null) 
		                { 
		                    // One child
		                    p = p.left;
		                } 
		                else 
		                { 
		                    // One or no children
		                    p = p.right;
		                }
		                
		                if (q == null) 
		                { 
		                    // No parent for p, root must change
		                    root = p;
		                } 
		                else 
		                {
		                    if (k1.compareTo(q.key) <0) 
		                    {
		                        q.left = p; } 
		                    else 
		                    {
		                        q.right = p;}
		                }
		                current = root;
		                return true;
		            }
		        }
		        return false; // Not found
		        }
		    //This method will update the value of the current by removing the old one and insert the new one
		    public boolean update(String key, Contact data)
		    
		    {   System.out.println(key + data.toString());  
		    	removeKey(current.key);
		                return insert(key, data);
		    }

		
		    //THIS METHOD WILL FIND THE Minimum IN BST AND return THE NODE WITH MIN VALUE
		
		    private BSTNode findmin(BSTNode  p)
		    {
		            if(p == null)
		                    return null;
		            while(p.left != null){
		                    p = p.left;
		            }

		            return p;
		    }

		
		    @Override
		    public String toString() 
		    {
		        String str = "";
		        if ( root == null)
		            return str="empty TREE";
		        str = printTraversal( root , str );
		        return str;
		    }

		
		    private String printTraversal (BSTNode  p ,String str)//This method will give us a string with alphabetic order of all contacts in the tree
		    {
		        if (p == null)
		            return "";
		        else
		        {
		            str = printTraversal(p.left , str);// IN ORDER Traversal We are starting from the left since it is the least alphabetic order then going to the root after that will reach the right side
		            str = str+ p.data.toString() + "    ";
		            str = str+printTraversal(p.right, str);
		        }
		        return str;
		    }
		    //ALL ARE THE PUBLIC METHOD RHAT THE USER CAN CALL FOR  Search ABOUT  ANY INFO FOR CONTACT

		    public boolean SearchPhone(String phone)
		    {
		    	if (root==null) {
					return false;
				}
		    	else
		        return SearchPhone(root, phone);
		    }
		    
		    public void SearchEmail(String email)
		    {
		        SearchEmail (root, email);
		    }
		    
		    public void SearchAddress(String address)
		    {
		        SearchAddress (root, address);
		    }
		    
		    public void SearchBirthday(String birthday)
		    {
		        SearchBirthday (root, birthday);
		    }
		    
		    public void SearchSameFirstName(String name)
		    {
		        SearchSameFirstName (root, name);
		    }



//SEARCHING FOR THE PHONE IT SHOULD BE IN ORDER Traversal AS IT'S REQUIRED , WHEN IT'S FOUND IT  return TRUE IMMEDIATELY AND EXIT
		    private boolean SearchPhone(BSTNode p, String phone)
		    {
		        if (p == null)
		            return false;
		        boolean foundleft=SearchPhone(p.left , phone) ;
		        	if (foundleft) {
		        		return true;
					}
		        	if (p.data.compareTo(phone,1) == 0)
		        {
		            current = p;
		            
		            return true;
		        }
		        
		        return  SearchPhone(p.right, phone);
		    }
		   
		    
		    //All the method here  they are not be unique so we have to search in both side of the tree and print the data immediately
		    private void SearchEmail(BSTNode p, String email)
		    {
		        if (p == null)
		            return;
		        
		        else  {  
	                    if (p.data.compareTo(email,2) == 0){
		            System.out.println(p.data);
	                    System.out.println("Contact has been found !");
	                    
	                        }
		        SearchEmail(p.left , email);
		        SearchEmail(p.right, email);
	                }
	               
		    }


		    private void SearchAddress (BSTNode  p, String address)
		    {
		        if (p == null)
		            return ;
		         
	                    if (p.data.compareTo(address,3) == 0){
		            System.out.println(p.data);
	                }
		        
		        SearchAddress(p.left , address);
		        SearchAddress(p.right, address);
	                
		    }
		    private void SearchBirthday (BSTNode  p, String birthday)
		    {
		        if (p == null)
		            return ;
		        
	                    if (p.data.compareTo(birthday,4) == 0){
		            System.out.println(p.data);
	                    }
		        
		        SearchBirthday(p.left , birthday);
		        SearchBirthday(p.right, birthday);
	                
		    }

		    private void SearchSameFirstName (BSTNode  p, String name)
		    {
		        if (p == null)
		            return ;
		        else    if (p.data.compareFirstName(name) == 0)
		       p.data.display();
		       
		        SearchSameFirstName(p.left , name);
		        SearchSameFirstName(p.right, name);
		    }

		class BSTNode {
	        public String  key;  
	        public Contact data;
	        public BSTNode left, right;

	      
	        public BSTNode() {
	                left = right = null;
	        }

	        public BSTNode( String key, Contact data) {
	                this.key = key  ;  
	                this.data = data;
	                left = right = null;
	        }

	        public BSTNode(String key, Contact data, BSTNode l, BSTNode r){
	                this.key = key  ;  
	                this.data = data;
	                left = l;
	                right = r;
	        }
	        @Override
	        public String toString() {
	            return " ["+ "key=" + key + ", data=" + data + "] ";
	        }


		}
		}//end of class

