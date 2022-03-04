package phase1allcodes;
import java.io.*; 
public class question26
{ 
Node head;
    	static class Node 
{ 
        		int data; 
        		Node next; 
        		Node(int d) 
        		{ 
            			data = d; 
            			next = null; 
        		} 
    	} 
// Method to insert a new node 
    	public static question26 insert(question26 list, int data) 
    	{ 
        		 
        		Node new_node = new Node(data); 
        		new_node.next = null; 
   		// If the Linked List is empty, then make the new node as head 
        		if (list.head == null) 
{ 
            			list.head = new_node; 
        		} 
        		else 
{ 
            			// Else traverse till the last node and insert the new_node there 
            			Node last = list.head; 
            			while (last.next != null) 
{ 
                			last = last.next; 
            			} 
   			// Insert the new_node at last node 
            			last.next = new_node; 
        		} 
        		return list; 
    	} 
   	public static void printList(question26 list) 
    	{	 
        		Node currNode = list.head; 
        		System.out.print("LinkedList: "); 
        		// Traverse through the LinkedList 
        		while (currNode != null) 
{ 
            			// Print the data at current node 
            			System.out.print(currNode.data + " "); 
            			// Go to next node 
            			currNode = currNode.next; 
        		} 
        		System.out.println(); 
    	} 
    	
    	public static question26 deleteByKey(question26 list, int key) 
    	{ 
        		
        		Node currNode = list.head, prev = null; 
        		if(currNode != null && currNode.data == key) 
{ 
            			list.head = currNode.next; // Changed head 
            			System.out.println(key + " found and deleted"); 
            			return list; 
        		} 
        		while (currNode != null && currNode.data != key) 
{ 
            			prev = currNode; 
            			currNode = currNode.next; 
        		} 
        		if (currNode != null) 
{ 
            			prev.next = currNode.next; 
            			System.out.println(key + " found and deleted"); 
        		} 
        		if (currNode == null) 
{ 
            			System.out.println(key + " not found"); 
        		} 
        		return list;
    	}
    	
    	public static void main(String[] args) 
    	{ 
        		
    		question26 list = new question26(); 
        		
        		list = insert(list, 10); 
        		list = insert(list, 20); 
        		list = insert(list, 30); 
        		list = insert(list, 40); 
        		list = insert(list, 50); 
        		list = insert(list, 60); 
        		list = insert(list, 70); 
        		list = insert(list, 80); 
        		
        		printList(list); 
        		
        		deleteByKey(list, 1); 
        		
        		printList(list); 
    	}
}