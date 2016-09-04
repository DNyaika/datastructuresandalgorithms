package com.algorithms.algorithms.fibonacci;

public class BruteForce {

	static int counter = 0;

	public static void main(String[] args) {

		System.out.println(fib(30));
		System.out.println("Counter>> "+counter);

	}

	static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		++counter;
		int x = fib(n - 2) + fib(n - 1);
		return x;
	}
}
