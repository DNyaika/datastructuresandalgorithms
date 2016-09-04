package com.algorithms.datastructures.Vector;


public class AVector implements IVector {
    private Node[] A;
    private int front;
    private int rear;
    private int size;

    public AVector(int size) {
        this.A = new Node[size];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }
    public Object elemAtRank(int r) {
        if (isValidRank(r)) { 
            int ix = rank2Index(r);
            return A[ix].elem;
        } else {
            return null;
        }
    }
    public Object replaceAtRank(int r, Object e) {
        if (isValidRank(r)) { 
            int ix = rank2Index(r);
            Object result = A[ix].elem;
            A[ix].elem = e;
            return result;
        } else {
            return null;
        }
    }
    public Position insertAtRank(int r, Object e) {
        checkForOverflow();
        if (isValidRank(r) || r == size) {
            Node n = new Node();
            n.elem = e;
            if (r < size/2) {
                front = (A.length + front - 1) % A.length;
                shiftLeft(0, r);
                int curr = rank2Index(r);
                n.index = curr;
                A[curr] = n;
            } else {
                rear = (rear + 1) % A.length;
                shiftRight(r, size);
                int curr = rank2Index(r);
                n.index = curr;
                A[curr] = n;
            }
            size++;
            return n;
        } else {
            System.out.println("Invalid Rank:" + r + ": did not insert: " + e);
            return null;
        }
    }
    public Object removeAtRank(int r) {
        if (isValidRank(r)) {
            int ix = rank2Index(r);
            Node n = A[ix];
            if (r < size/2) {
                shiftRight(0, r);
                front = (front + 1) % A.length;
            } else {
                shiftLeft(r, size-1);
                rear = (A.length + rear - 1) % A.length;
            }
            size--;
            return n.element();
        } else {
            System.out.println("There is no element at rank " + r);
            return null;
        }
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder result = new StringBuilder(100);
        result.append("[[ ");
        if (0<size) {
            int ix = rank2Index(0);
            result.append(A[ix]);
        }
        for (int r=1; r<size; r++) {
            int ix = rank2Index(r);
            result.append(", " + A[ix]);
        }
        result.append(" ]] (" + front + ", " + rear + "), size=" + size);
        return result.toString();
    }

    int rankOf(Position p) {
        int r = index2Rank(((Node)p).index);
        return r;
    }
    protected Position atRank(int r) {
        if (isValidRank(r)) { 
            int ix = rank2Index(r);
            return A[ix];
        } else {
            return null;
        }
    }

    private int rank2Index(int r) {
        return (front+r) % A.length;
    }
    private int index2Rank(int i) {
        int r = (A.length - front + i) % A.length;
        return r;
    }
    private boolean isValidRank(int r) {
        return (r>=0 && r<size);
    }
    private void shiftRight(int r1, int r2) {
        int curr = rank2Index(r2);
        for (int i=r2; i>r1; i--) {
            int prev = rank2Index(i-1);
            A[curr] = A[prev];
            A[curr].index = curr;
            curr = prev;
        }
    }
    private void shiftLeft(int r1, int r2) {
        int curr = rank2Index(r1);
        for (int i=r1; i<r2; i++) {
            int prev = rank2Index(i+1);
            A[curr] = A[prev];
            A[curr].index = curr;
            curr = prev;
        }
    }
    private void checkForOverflow() {
        if (size >= A.length -1) {
            Node[] newA = new Node[A.length*2];
            for (int i=0; i<size; i++) {
		int ix = rank2Index(i);
                newA[i] = A[ix];
                newA[i].index = i;
            }
            A = newA;
            front = 0;
            rear = size-1;
        }
    }
    static private class Node implements Position {
        private Object elem;
        private int index;

        public Object element() {
            return elem;
        }
        public String toString() {
            return "(" + index + ", " + elem + ")";
        }
    }

}
