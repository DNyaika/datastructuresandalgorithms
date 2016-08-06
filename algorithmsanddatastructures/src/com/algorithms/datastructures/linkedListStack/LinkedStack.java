package com.algorithms.datastructures.linkedListStack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements Iterable<E> {
	private int size; // size of the stack
	private Node<E> first; // top of stack

	// helper linked list class
	private class Node<T> {
		private T data;
		private Node<T> next;
	}

	/**
	 * Initializes an empty stack.
	 */
	public LinkedStack() {
		first = null;
		size = 0;
	}

	/**
	 * Is this stack empty?
	 * 
	 * @return true if this stack is empty; false otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Returns the number of items in the stack.
	 * 
	 * @return the number of items in the stack
	 */
	public int size() {
		return size;
	}

	/**
	 * Adds the item to this stack.
	 * 
	 * @param item
	 *            the item to add
	 */
	public void push(E data) {
		Node<E> oldfirst = first;
		first = new Node<E>();
		first.data = data;
		first.next = oldfirst;
		size++;
	}

	/**
	 * Removes and returns the item most recently added to this stack.
	 * 
	 * @return
	 * 
	 * @return the item most recently added
	 * @throws java.util.NoSuchElementException
	 *             if this stack is empty
	 */
	public E pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		E data = first.data; // save item to return
		first = first.next; // delete first node
		size--;
		return data; // return the saved item
	}

	/**
	 * Returns (but does not remove) the item most recently added to this stack.
	 * 
	 * @return the item most recently added to this stack
	 * @throws java.util.NoSuchElementException
	 *             if this stack is empty
	 */
	public E peek() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return first.data;
	}

	/**
	 * Returns a string representation of this stack.
	 * 
	 * @return the sequence of items in the stack in LIFO order, separated by
	 *         spaces
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (E data : this)
			s.append(data + " ");
		return s.toString();
	}
	
	/**
	 * Returns an iterator to this stack that iterates through the items in LIFO
	 * order.
	 * 
	 * @return an iterator to this stack that iterates through the items in LIFO
	 *         order.
	 */
	
	public Iterator<E> iterator() {
		return new ListIterator();
	}
	
    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<E> {
        private Node<E> current = first;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E data = current.data;
            current = current.next; 
            return data;
        }
    }


}
