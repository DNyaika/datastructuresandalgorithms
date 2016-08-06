package com.algorithms.datastructures.doublylinkedlist;

//Testing remove at
public class Main5 {
	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		dll.addToBegining(5);
		dll.addToBegining(20);
		dll.print();
		System.out.println("Size: "+dll.size());
		System.out.println("------------------------------");
		dll.addToEnd(10);
		dll.print();
		System.out.println("Size: "+dll.size());
		System.out.println("------------------------------");
		dll.insertAt(36, 0);
		dll.insertAt(45, 1);
		dll.print();
		System.out.println("Size: "+dll.size());
		System.out.println("------------------------------");
		dll.removeAt(2);
		dll.print();
		System.out.println("Size: "+dll.size());
	}
}
