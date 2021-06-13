package learn.ds.list.linkedList;

import java.util.LinkedList;

class Node {
	Node next;
	Object data;

	public Node(Object data) {
	 	this.next = null;
	 	this.data = data;
	} 
	
	public Node(Object data, Node next) {
		this.next = next;
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}

class MyLinkedList{
	private static int size;
	
}

public class CustomLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
