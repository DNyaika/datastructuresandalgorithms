package com.algorithms.datastructures.singlylinkedlist;

//testing equals method
public class Main3 {
	public static void main(String[] args) {
		MySinglyLinkedList<String> list = new MySinglyLinkedList<>();
		MySinglyLinkedList<String> list2 = new MySinglyLinkedList<>();

		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");

		list2.add("1");
		list2.add("2");
		list2.add("3");
		list2.add("4");

		System.out.println(list.equals(list2));
	}
}
