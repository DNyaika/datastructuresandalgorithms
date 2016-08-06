package com.algorithms.datastructures.doublylinkedlist;

//testing Add to end of the link
public class Main1 {
	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		dll.addToBegining(5);
		dll.addToBegining(20);
		dll.print();
		System.out.println("------------------------------");
		dll.addToEnd(10);
		dll.print();
	}
}
