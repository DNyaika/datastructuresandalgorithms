package com.algorithms.datastructures.dijkstrastwostackalgorithm;

import java.util.Stack;

public class Evaluate {
	public static void main(String[] args) {
		String string = "(1+((2+3)*(4*5)))";
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		int counter = 0;
		while (counter < (string.length())) {
			String s = String.valueOf(string.charAt(counter));
			if (s.equals("("))
				;
			else if (s.equals("+"))
				ops.push(s);
			else if (s.equals("*"))
				ops.push(s);
			else if (s.equals(")")) {
				String op = ops.pop();
				if (op.equals("+"))
					vals.push(vals.pop() + vals.pop());
				else if (op.equals("*"))
					vals.push(vals.pop() * vals.pop());
			} else
				vals.push(Double.parseDouble(s));
			++counter;
		}
		System.out.println(vals.pop());
	}
}
