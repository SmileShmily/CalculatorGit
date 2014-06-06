package com.example.model.test;

import java.util.Stack;

import com.exmaple.model.CalModel;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CalModelTest extends TestCase {

	public CalModelTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public void testPopOpOffStack()
	{
		Stack<String> src = new Stack<String>();
		src.push("2");
		src.push("+");
		src.push("1");
		src.push("*");
		src.push("2");
		src.push("-");
		src.push("3");
		
		double expected = 3.0;
		double result = CalModel.popOpOffStack(src);
		
		Assert.assertEquals(expected, result, 0.01);
	}

}
