package com.algorithms.datastructures.singlylinkedlist;

//test contains method
public class Main4 {
	public static void main(String args[]) {
		MySinglyLinkedList<String> list = new MySinglyLinkedList<>();

		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");

		System.out.println(list.contains("1"));
	}

}
