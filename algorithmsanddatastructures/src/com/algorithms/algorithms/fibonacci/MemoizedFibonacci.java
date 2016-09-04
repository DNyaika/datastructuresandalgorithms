package com.algorithms.algorithms.fibonacci;

public class MemoizedFibonacci {

static int counter = 0;
	
	public static void main(String[] args) {

		System.out.println(fib(8));
		System.out.println("Counter>> "+counter);

	}

	static int fib(int n) {
	  int [] f = new int[n+1];
        for(int i = 0; i <= n; i ++){
            f[i] = -1;
        }
        return memoizedFib(n,f);
	}

	static int memoizedFib(int n, int f[]) {
            counter++;
		if (f[n] < 0) {
                    if (n == 0)
                        f[n] = 0;
                    else if (n == 1)
                        f[n] = 1;
                    else
                        f[n]  = memoizedFib(n-2, f) + memoizedFib(n-1, f);
		}
		return f[n];
	}
}