package com.algorithms.datastructures.linkedlist.doublylinkedlist;

//Testing remove from begining
public class Main2 {
	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		dll.addToBegining(5);
		dll.addToBegining(20);
		dll.print();
		System.out.println("------------------------------");
		dll.addToEnd(10);
		dll.print();
		System.out.println("------------------------------");
		dll.removeFromBegining();
		dll.print();
	}
}
