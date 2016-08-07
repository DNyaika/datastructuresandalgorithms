package com.algorithms.datastructures.doublylinkedlist;

//testing remove from end
public class Main3 {
	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		dll.addToBegining(5);
		dll.addToBegining(20);
		dll.print();
		System.out.println("------------------------------");
		dll.addToEnd(10);
		dll.print();
		System.out.println("------------------------------");
		dll.removeFromEnd();
		dll.print();
	}
}
