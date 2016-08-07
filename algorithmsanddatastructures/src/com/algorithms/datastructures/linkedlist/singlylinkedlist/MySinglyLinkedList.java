package com.algorithms.datastructures.linkedlist.singlylinkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

@SuppressWarnings("rawtypes")
public class MySinglyLinkedList<E> implements List {
	private Node<E> head;
	private Node<E> tail;
	private int currentSize;

	public MySinglyLinkedList() {
		this.head = null;
		this.tail = null;
		this.currentSize = 0;
	}

	class Node<T> {
		private Node<T> next;
		private T data;

		public Node(T data, Node<T> next) {
			this.next = next;
			this.data = data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

	}

	class LinkedListIterator implements Iterator<E> {

		private Node<E> current;
		private Node<E> previous;
		private Node<E> previous2;

		private boolean removeCalled;

		public LinkedListIterator() {
			current = head;
			previous = null;
			previous2 = null;
			removeCalled = false;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			if (current == null) {
				throw new NoSuchElementException();
			}
			E temp = current.getData();
			previous2 = previous;
			previous = current;
			current = current.getNext();
			removeCalled = false;
			return temp;
		}

		public void remove() {
			if (previous == null || removeCalled) {
				throw new IllegalStateException();
			}
			if (previous2 == null) {
				head = current;
			} else {
				previous2.setNext(current);
				previous = previous2;
			}
			currentSize--;
			removeCalled = true;
		}

	}

	@Override
	public int size() {
		return currentSize;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		for (Object e : this) {
			if (o == null ? e == null : o.equals(e)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator iterator() {
		return new LinkedListIterator();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	// adds at the end of the linked list
	@Override
	public boolean add(Object e) {
		if (isEmpty()) {
			head = new Node(e, null);
			tail = head;
		} else {
			tail.setNext(new Node(e, null));
			tail = tail.getNext();
		}
		currentSize++;

		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		currentSize = 0;

	}

	@Override
	public Object get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		if (index < size() - 1) {
			Node<E> current = head;
			for (int j = 0; j < index; j++) {
				current = current.getNext();
			}
			return current.getData();
		}

		// if index is equal to size()-1
		return tail.getData();
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	// Adding to a position in a linked list
	@Override
	public void add(int index, Object element) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		if (index == size()) {
			add(element);
			return;
		}
		if (index == 0) {
			head = new Node(element, head);
		} else {
			Node<E> current = head;
			for (int j = 0; j < index - 1; j++) {
				current = current.getNext();
			}
			// Current is now the node before the index where we want to add
			current.setNext(new Node(element, current.getNext()));
		}

		currentSize++;
	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof List) {
			List otherList = (List) o;
			if (this.size() == otherList.size()) {
				Iterator list1 = this.iterator();
				Iterator list2 = otherList.iterator();

				while (list1.hasNext()) {
					Object e1 = list1.next();
					Object e2 = list2.next();

					if (!(e1 == null ? e2 == null : e1.equals(e2))) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

}
