package LinkedList;

public class LinkedList {
	private Link first; //head
	LinkedList(int newdata){
		first = new Link(newdata);
	}
	private class Link{
		int data;
		Link next;
		
		Link(int newdata){
			data = newdata;
		}
	}
	
	public void insert(int value){
		if (first == null) {
			first = new Link(value);
			return;
		}
		Link current = first;
		while(current.next != null){
			current = current.next;
		}
		current.next= new Link(value);
		
	}
	
	public int size(){
		int n =0;
		Link current = first;
		//This idiom checks for current and not current.next!!
		while(current != null){
			System.out.println(Integer.toString(current.data));
			current = current.next;
			n++;
		}
		return n; 
	}
	
	void printList(){
		Link current = first;
		while(current!=null){
			System.out.print(Integer.toString(current.data)+" ");
			current= current.next;
		}	
	}
	//How do you delete an object
	//copying object in Java
	//http://stackoverflow.com/questions/869033/how-do-i-copy-an-object-in-java
	void deleteList3(){
		Link current = first;
		while(current!=null){
			Link temp = current;
			current = current.next;
			temp = null; // only sets the variable to null
		}
		//first = null;
	}
	
}
