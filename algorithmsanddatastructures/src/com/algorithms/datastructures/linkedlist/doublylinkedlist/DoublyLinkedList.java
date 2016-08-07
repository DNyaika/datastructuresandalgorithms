package com.algorithms.datastructures.doublylinkedlist;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {

	private Node<E> head;
	private int size;

	public DoublyLinkedList() {
		head = null;
		size = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addToBegining(E data) {
		if (head == null) {
			head = new Node<E>(null, data, null);
		} else {
			Node<E> newNode = new Node<E>(null, data, head);
			head.previous = newNode;
			head = newNode;
		}
		size++;
	}

	public void addToEnd(E data) {
		if (head == null) {
			head = new Node<E>(null, data, null);
		} else {
			Node<E> current = head;
			while (current.next != null) {
				current = current.next;
			}
			Node<E> newNode = new Node<E>(current, data, null);
			current.next = newNode;
		}
		size++;
	}

	public void removeFromBegining() {
		if (head == null)
			return;
		head = head.next;
		head.previous = null;
		size--;
	}

	public void removeFromEnd() {
		if (head == null)
			return;
		if (head.next == null) {
			head = null;
			size--;
			return;
		}
		Node<E> current = head;
		while (current.next.next != null) {
			current = current.next;
		}
		current.next = null;
		size--;
	}

	public void insertAt(E data, int index) {
		if (head == null) {
			throw new NoSuchElementException();
		}

		if (index < 0 || index > size) {
			throw new IllegalArgumentException();
		}

		Node<E> current = head;
		int i = 0;
		while (i < index) {
			current = current.next;
			i++;
		}
		if (current.previous == null) {
			Node<E> newNode = new Node<E>(null, data, current);
			current.previous = newNode;
			head = newNode;
		} else {
			Node<E> newNode = new Node<E>(current.previous, data, current);
			current.previous.next = newNode;
			current.previous = newNode;

		}
		size++;

	}

	public void removeAt(int index) {
		if (head == null) {
			throw new NoSuchElementException();
		}

		if (index < 0 || index > size) {
			throw new IllegalArgumentException();
		}

		Node<E> current = head;
		int i = 0;
		while (i < index) {
			current = current.next;
			i++;
		}
		if (current.next == null) {
			current.previous.next = null;
		} else if (current.previous == null) {
			current = current.next;
			current.previous = null;
			head = current;
		} else {
			current.previous.next = current.next;
			current.next.previous = current.previous;
		}
		size--;
	}

	public void print() {
		Node<E> current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	public int size() {
		return size;
	}

	class Node<T> {
		private T data;
		private Node<T> previous;
		private Node<T> next;

		public Node(T data) {
			previous = null;
			this.data = data;
			next = null;
		}

		public Node(Node<T> previous, T data, Node<T> next) {
			this.previous = previous;
			this.data = data;
			this.next = next;
		}

		public T getData() {
			return data;
		}
	}
}
