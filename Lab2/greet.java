//Luke Lai
//1355154
//cmps012b
//10/14/14
//greet.java
//Asks user to type their name, then says hello.

import static java.lang.System.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class greet{
	public static void main( String[] args ){
		boolean loop = true;
		BufferedReader in = new BufferedReader(
			new InputStreamReader(System.in));
		while(loop){
		try{
			System.out.println("What is your name?");
			String name = in.readLine();
			System.out.println("Hello, " +name+ ".");
	//	loop = false;
		}catch(IOException io) {
			io.printStackTrace();
		}
	}
}
}
