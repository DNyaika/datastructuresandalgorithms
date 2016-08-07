package com.algorithms.datastructures.linkedlist.singlylinkedlist;
//testslinked list 
public class Main {

	public static void main(String[] args) {
		MySinglyLinkedList<String> list = new MySinglyLinkedList<>();
		list.add("1");
		list.add("2");
		list.add(0, "3");
		list.add(2, "4");

		// expected output 3->1->4->2
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
	}
}
