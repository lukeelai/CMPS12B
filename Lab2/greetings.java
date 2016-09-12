//Luke Lai
//1355154
//cmps012b
//10/14/14
//greetings.java
//Greet everyone listed in people.txt

import static java.lang.System.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

class greetings {
	public static void main( String[] args ) throws IOException {
		BufferedReader in = new BufferedReader(
			new FileReader("directory.txt"));
		while(true) {
			String name = in.readLine();
			//String[] matches = name.split(",");
			if (name == null) break;
			String[] matches = name.split(",");
		for( int i = 0; i < matches.length; i++);
			int temp = matches[0];
			System.out.println(temp);
		}
		//in.close();
	}
}
