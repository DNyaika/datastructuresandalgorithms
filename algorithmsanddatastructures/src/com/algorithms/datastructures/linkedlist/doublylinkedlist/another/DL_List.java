package com.algorithms.datastructures.linkedlist.doublylinkedlist.another;

public class DL_List implements IList {
    private int size;
    private Node header;
    private Node trailer;

    public DL_List() {
        header = new Node();
        trailer = new Node();
        linkNodes(header, trailer);
        size = 0;
    }

    public Position first() {
        return (header.next == trailer)? null : header.next;
    }
    public Position last() {
        return (trailer.prev == header)? null : trailer.prev;
    }
    public boolean isFirst(Position p) {
        return (p == header.next);
    }
    public boolean isLast(Position p) {
        return (p == trailer.prev);
    }
    public Position before(Position p) {
        Node temp = ((Node)p).prev;
        return (temp == header)? null : temp;
    }
    public Position after(Position p) {
        Node temp = ((Node)p).next;
        return (temp == trailer)? null : temp;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public Object replaceElement(Position p, Object e) {
        Object old = p.element();
        ((Node)p).elem = e;
        return old;
    }
    public void swapElements(Position p, Position q) {
        Object temp = p.element();
        ((Node)p).elem = q.element();
        ((Node)q).elem = temp;
    }
    public Position insertFirst(Object e) {
        return insertAfter(header, e);
    }
    public Position insertLast(Object e) {
        return insertBefore(trailer, e);
    }
    public Position insertBefore(Position q, Object e) {
        Node p = ((Node)q).prev;
        Node v = new Node();
        v.elem = e;
        linkNodes(p, v);
        linkNodes(v, (Node)q);
        size++;
        return v;
    }
    public Position insertAfter(Position p, Object e) {
        Node q = ((Node)p).next;
        Node v = new Node();
        v.elem = e;
        linkNodes((Node)p, v);
        linkNodes(v, q);
        size++;
        return v;
    }
    public Object remove(Position p) {
        Node v = ((Node)p).prev;
        Node q = ((Node)p).next;
        linkNodes(v, q);
        ((Node)p).next = null;
        ((Node)p).prev = null;
        size--;
        return p.element();
    }
    public String toString() {
        StringBuilder result = new StringBuilder(100);
        result.append("<< ");
        Node curr = header.next;
        if (curr != trailer) {
            result.append(curr.element());
            curr = curr.next;
        }
        while (curr != trailer) {
            result.append(", " + curr.element());
            curr = curr.next;
        }
        result.append(" >>, size=" + size);
        return result.toString();
    }

    private void linkNodes(Node p, Node q) {
        p.next = q;
        q.prev = p;
    }

    static private class Node implements Position {
        private Object elem;
        private Node prev;
        private Node next;

        public Object element() {
            return elem;
        }
        public String toString() {
            return elem.toString();
        }
    }

}
