package com.mardev.calculator.service;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
	
	@Test
	public void test_Addition() {
		Calculator myCalc = new Calculator();
		int result = myCalc.eval((i, j ) -> i + j , 10, 20);
		Assert.assertEquals(30, result);
	}
	
	
	@Test
	public void test_Substraction() {
		Calculator myCalc = new Calculator();
		int result = myCalc.eval((i, j ) -> i - j , 3, 1);
		Assert.assertEquals(2, result);
	}
	
	@Test
	public void test_Multiplication() {
		Calculator myCalc = new Calculator();
		int result = myCalc.eval((i, j ) -> i * j , 3, 2);
		Assert.assertEquals(6, result);
	}
	
	
	@Test
	public void test_Division() {
		Calculator myCalc = new Calculator();
		int result = myCalc.eval((i, j ) -> i / j , 20, 2);
		Assert.assertEquals(10, result);
	}
	
	@Test
	public void test_Expression_1() {
		Calculator myCalc = new Calculator();
		String exp = "3+5";
		int result = myCalc.calculateExpression(exp);
		System.out.println("Result is: " + result);
		Assert.assertEquals(8, result);
	}

}
