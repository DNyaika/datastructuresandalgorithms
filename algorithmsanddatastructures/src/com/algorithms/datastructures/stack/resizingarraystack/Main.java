package com.algorithms.datastructures.stack.resizingarraystack;

public class Main {

	public static void main(String[] args) {
		 ResizingArrayStack<Integer> st = new  ResizingArrayStack<Integer>();

		st.push(50);
		st.push(70);
		st.push(190);
		System.out.println(st.toString());
		System.out.println("---------------------------------------");
		st.pop();
		System.out.println(st.toString());

	}
}