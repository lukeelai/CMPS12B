//Luke Lai
//luelai
//1355154
//10/22/14
//Calc.java
//Define a class for doing RPN.

import java.util.*;

public class Calc {

	private double[] stack = new double[100];
	private int top = -1;
    	
	// Constructor
    	public Calc() {
	}

    	// Push a number
    	public void push(double x) {
    		if (top == 99)
			throw new RuntimeException();
			top++;
			stack[top] = x;
	}

    	// Pop top number (removes)
    	public double pop() {
		if(top < 0)
			throw new RuntimeException();
			return stack[top--];
	}		

    	// Peek at top number (does not remove)
   	public double peek() {
        	if(top < 0)
			throw new RuntimeException();
			return stack[top];	
    	}

    	// Add top two numbers
    	public void add() {
		if(top < 1){
			throw new RuntimeException();
		}else{
			stack[top - 1] = stack[top] + stack[top - 1];
			top--;
		}
	}

   	// Subtract top two numbers (top on right side)
    	public void subtract() {
    		if(top < 1){
			throw new RuntimeException();
		}else{
			stack[top - 1] = stack[top -1] - stack[top];
			top--;
		}
	}

    	// Multiply top two numbers
    	public void multiply() {
    		if(top < 1){
			throw new RuntimeException();
		}else{
			stack[top - 1] = stack[top] * stack[top - 1];
			top--;
		}
	}


    	// Divide top two numbers (top on bottom)
    	public void divide() {
    		if(top < 1){
			throw new RuntimeException();
		}else{
			stack[top - 1] = stack[top - 1] / stack[top];
			top--;
		}
	}

	public void reciprocal(){
		if( top < 1)
			throw new RuntimeException();
			stack[top] = (1 / stack[top]);
	}

    	// Return how many numbers are in the stack
    	public int depth() {
        	return top + 1;
	}

	public boolean isEmpty(){
		return (top == -1);
	
	}

	public boolean isFull(){
		return (top == 99);
	}
}
