// Luke Lai Gabriel Reyes
// 1355154 1348575
// luelai ghreyes
// 10/29/14
// edfile.java
// Template for a line-oriented text editor inspired by ed.

import java.util.Scanner;
import static java.lang.System.*;
import java.io.*;

class edfile{

   public static void main (String[] args) {
      System.out.println("Welcome");
      boolean want_echo = true;
      dllist lines = new dllist ();
      auxlib.STUB ("Check for -e option");
      auxlib.STUB ("Load file from args filename, if any.");
      Scanner stdin = new Scanner (in);
      String blah = args[0];
      System.out.println("Options = " + blah.charAt(0));
      System.out.println("Operands = " + blah.substring(2));
      try{
	File f = new File(args[0].substring(2));
      	Scanner s = new Scanner(f);
	while(s.hasNextLine())
		System.out.println(s.nextLine());
	}catch (FileNotFoundException e){
		//blah
	}
      dllist list = new dllist();
      for (;;) {
         if (! stdin.hasNextLine()) break;
         String inputline = stdin.nextLine();
         if (want_echo) out.printf ("%s%n", inputline);
         if (inputline.matches ("^\\s*$")) continue;
         char command = inputline.charAt(0);
	 String operand = inputline.substring(2);
         switch (command) {
            case '#': break;
            case '$': list.setPosition(dllist.position.LAST);
		      list.getItem();
		      break;
            case '*': list.setPosition(dllist.position.FIRST);
	 	      while(list.getItem() != null){
			list.getItem();
			list.setPosition(dllist.position.FOLLOWING);
			}
			break;
            case '.': list.getItem(); break;
            case '0': list.setPosition(dllist.position.FIRST);
		      list.getItem();
		      break;
            case '<': list.setPosition(dllist.position.PREVIOUS);
		      list.getItem();
		      break;
            case '>': list.setPosition(dllist.position.FOLLOWING);
		      list.getItem();
		      break;
            case 'a': list.insert(operand, dllist.position.FOLLOWING); break;
            case 'd': list.delete(); break;
            case 'i': list.insert(operand, dllist.position.LAST); break;
            case 'r': 	try{
			File fi = new File(operand);
		      	Scanner scan = new Scanner(fi);
		      	int count = 0;
		      	while(scan.hasNext()){
			list.insert(scan.nextLine(), dllist.position.FOLLOWING);
			list.setPosition(dllist.position.FOLLOWING);
			count++;
		      }
		      System.out.println(count + "lines inserted");
		      }catch(FileNotFoundException e){
			System.out.println("File is empty");
			}
		      break;
            case 'w': while(operand != null){
			File file = new File(operand);
		      	list.setPosition(dllist.position.FIRST);
			}
		      while(list.getItem() != null){
			File file = new File(operand); 
			list.setPosition(dllist.position.FOLLOWING);
			System.out.println(list.getItem());
		      }
		      break;
            default : auxlib.STUB ("Print invalid command."); break;
         }
      }
      auxlib.STUB ("(eof)");
   }

}
