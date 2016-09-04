package com.algorithms.algorithms.fibonacci;

public class Fib {
	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			System.out.println(fib(i));
		}

	}

	static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int x = fib(n - 2) + fib(n - 1);
		return x;
	}
}
