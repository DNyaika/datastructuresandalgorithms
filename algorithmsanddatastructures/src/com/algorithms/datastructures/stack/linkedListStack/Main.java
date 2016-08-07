package com.algorithms.datastructures.stack.linkedListStack;

public class Main {

	public static void main(String[] args) {
		LinkedStack<Integer> st = new LinkedStack<Integer>();

		st.push(50);
		st.push(70);
		st.push(190);
		System.out.println(st.toString());
		System.out.println("---------------------------------------");
		st.pop();
		System.out.println(st.toString());

	}
}