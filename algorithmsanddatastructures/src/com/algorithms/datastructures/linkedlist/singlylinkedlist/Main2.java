package com.algorithms.datastructures.linkedlist.singlylinkedlist;

import java.util.Iterator;
//tests iterator
public class Main2 {
	public static void main(String[] args) {
		MySinglyLinkedList<String> list = new MySinglyLinkedList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");

		Iterator iter = list.iterator();

		System.out.println(iter.next()); // Should be 1
		System.out.println(iter.next());// should be 2
		System.out.println(iter.hasNext());// hould be true
		System.out.println(iter.next()); // should be 3
		System.out.println(iter.next());// should be 4
		iter.remove();
		System.out.println(iter.hasNext());// should be false

		for (Object s : list) {
			System.out.println(s.toString());
		}
	}

}
