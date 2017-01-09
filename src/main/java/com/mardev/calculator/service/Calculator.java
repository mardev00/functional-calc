package com.mardev.calculator.service;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.BinaryOperator;

public class Calculator {

	public int getInt(Queue<Character> charQueue) {
		StringBuilder sb = new StringBuilder();
		for (Character c : charQueue) {
			sb.append(c);
		}
		int operand = Integer.valueOf(sb.toString());
		return operand;

	}

	public int calculateExpression(String s) {
		// build Expression
		Expression e = new Expression();
		Stack<Integer> operandsStack = new Stack<>();
		Stack<Character> operatorsStack = new Stack<>();
		Stack<Integer> secondoOperandsStack = new Stack<>();
		Stack<Character> secondOperatorsStack = new Stack<>();
		e.secondOperands = secondoOperandsStack;
		e.secondOperators = secondOperatorsStack;
		e.operands = operandsStack;
		e.operators = operatorsStack;
		System.out.println("String s is: " + s);
		Queue<Character> charQueue = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			// System.out.print(s.charAt(i));
			if (Character.isDigit(s.charAt(i))) {
				charQueue.add(s.charAt(i));
				System.out.println(s.charAt(i) + " is digit");
				// save this digit to a temp memory structure and get an int
			}
			if (i == s.length() - 1) {
				int operand = getInt(charQueue);
				e.operands.push(operand);
			}
			if (!Character.isDigit(s.charAt(i))) {
				int operand = getInt(charQueue);
				e.operands.push(operand);
				e.operators.push(s.charAt(i));
				System.out.println(s.charAt(i) + " is Not digit");
				charQueue = new LinkedList<>();
			}

		}
		return eval(e, e.operands.pop());

	}

	public  int eval(Expression e, int result) {

		while (!e.operands.isEmpty()) {
			if (e.operators.peek().equals('+') || e.operators.peek().equals('-')) {
				e.secondOperands.push(result);
				e.secondOperands.push(e.operands.pop());
				e.secondOperators.push(e.operators.pop());
			}
		}
		
		return getResult(e);

	}
	
	public int getResult(Expression e) {
		int result = 0;

		for ( Character op: e.secondOperators) {
			if(op == '+')
				result = eval((i,j) -> i + j, result, e.secondOperands.pop());
			else if(op == '-')
				result = eval((i,j) -> i - j, result, e.secondOperands.pop());
			
		}
		
		
		return result;
		}


	// eval((i, j ) -> i - j , 3, 1);
	public  int eval(BinaryOperator<Integer> oper, int i1, int i2) {
		return oper.apply(i1, i2);
	}

}
