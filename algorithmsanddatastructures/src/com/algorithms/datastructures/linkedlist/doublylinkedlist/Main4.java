package com.algorithms.datastructures.doublylinkedlist;

public class Main4 {
	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		dll.addToBegining(5);
		dll.addToBegining(20);
		dll.print();
		System.out.println("------------------------------");
		dll.addToEnd(10);
		dll.print();
		System.out.println("------------------------------");
		dll.insertAt(36,0);
		dll.print();
	}
}
