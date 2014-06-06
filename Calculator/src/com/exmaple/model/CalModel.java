package com.exmaple.model;

import java.util.Stack;

import com.example.interfaces.ICalculator;

public class CalModel implements ICalculator {

	
	public static double popOpOffStack(Stack<String> stack){
		double result = 0;
		double operand = Double.valueOf(stack.pop());
		
		if(stack.isEmpty()){
			return operand;
		}
		
		String operate = stack.pop();
		if(operate.equals("+")){
			result = CalModel.popOpOffStack(stack) + operand;
		}
		else if(operate.equals("-")){
			result = CalModel.popOpOffStack(stack) - operand;
		}
		else if(operate.equals("*")){
			result = CalModel.popOpOffStack(stack) * operand;
		}
		else if(operate.equals("/")){
			result = CalModel.popOpOffStack(stack) / operand;
		}
		
		return result;
		
	}
	
	
	private Stack<String> dataStack = new Stack<String>();
	
	private boolean isOperate = false;
	
	@Override
	public void pushOperand(String operand) {
		dataStack.add(operand);
		isOperate = false;
	}

	@Override
	public double pushOperate(String operate) {
		double result = 0;
		
		if(isOperate){
			dataStack.pop();
		}
		
		if(operate.equals("=")){
			result = CalModel.popOpOffStack(dataStack);
		}
		else{
			@SuppressWarnings("unchecked")
			Stack<String> tempStack = (Stack<String>)dataStack.clone();
			result = CalModel.popOpOffStack(tempStack);
			dataStack.add(operate);
			isOperate = true;
		}
		
		return result;
	}

	@Override
	public void reset() {
		dataStack.removeAllElements();
		isOperate = false;
	}

}
