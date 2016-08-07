package com.algorithms.datastructures.linkedlist.doublylinkedlist;

//testing Add to Beginning of the link
public class Main {

	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		dll.addToBegining(5);
		dll.addToBegining(6);
		dll.print();
	}

}
