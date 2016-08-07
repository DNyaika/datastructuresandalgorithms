package com.algorithms.datastructures.queue.linkedlistqueue;

public class Main {
	public static void main(String[] args) {
		LinkedQueue<Integer> q = new LinkedQueue<Integer>();

		q.enqueue(50);
		q.enqueue(70);
		q.enqueue(190);
		System.out.println(q.toString());
		System.out.println("---------------------------------------");
		q.dequeue();
		System.out.println(q.toString());
	}
}
