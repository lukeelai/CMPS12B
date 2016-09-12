/*
 * Luke Lai  and Gabriel Reyes
 * luelai    and   ghreyes
 * CMPS 12B
 * 12/7/2014
 * cyoa.java
 * create your own adventure file that reads text in from a file to 
 * create a world then allows user to interact with that world
 */
import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

class cyoa {
  //scanner for system input (commands, not file)
  static final Scanner input = new Scanner(System.in);
  public static void main(String[] args) throws IOException {
    //scanner for file containing how the world is built
    Scanner scan = new Scanner (new File(args[0]));
    
    
    //builds "world". Creates empty array for room storage
    Room[] world= new Room[30];
    //currRoom = room currently being worked on
    int currRoom = -1;
    
    
    while(scan.hasNextLine()){
      //line = next line of file read in
      String line= scan.nextLine();
      //does nothing if line is blank
      if(!line.isEmpty()){
        //cmd = first char of line
        char cmd= line.charAt(0);
        String content;
        //for if the option has no arguments
        if(line.substring(2)==null){
          //content = characters following the command
          System.out.println("File contains invalid commands.");
          break;
        }
        else {
          content = line.substring(2);
        }
        
        
        //Command Specification
        if(cmd=='r'){
          //add new room
          currRoom++;
          Room r= new Room(content);
          world[currRoom]=r;
        }
        else if(cmd=='d'){
          //add description to last room made
          world[currRoom].addDes(content);
        }
        else if(cmd=='o'){
          //add option to room
          world[currRoom].addOpt(content);
        }
        else if(cmd=='t'){
          //sets destination room for last option added
          //searches for room that matches input
          world[currRoom].addTag(content);
        }
        //DEBUG
        //shows all rooms and their structure when 
        //"u" is added to end of text file
        /*
         else if (cmd=='u'){
         for(int i=0; world[i]!=null; i++){
         System.out.println(world[i].getName());
         world[i].printAllDes(); 
         world[i].printAllOpt();
         }
         }
         */
        
        //tells users input is invalid
        else System.out.println("File contains invalid commands");
      }
    }
    
    currRoom=0;
    world[0].printAllDes();
    char z='a';
    Onode curr=world[currRoom].firstOpt;
    while(curr!=null){
      System.out.println(z + " : " + curr.getD());
      curr=curr.next;
      z++;
    }
    //initializes Dllist for room history
    Dllist historyf = new Dllist(currRoom);
    historyf.prev=null;
    historyf.next=null;
    Dllist historyL=historyf;
    
    //GAMEPLAY
    while(input.hasNextLine()){
      
      String inp=input.nextLine();
      //for blank line input
      if(inp.isEmpty())
        System.out.println("Please enter a command.");
      else{
        char in = inp.charAt(0);        
        
        if(in=='a'){
          //if current room doesn't have this option, print error
          if(world[currRoom].firstOpt==null)
            System.out.println("Invalid command.");
          //else say you did that option
          else{
            System.out.println("You " + world[currRoom].firstOpt.getD());
            //checks to see if room transfer is needed
            if(world[currRoom].firstOpt.getDestination()!=null){
              for(int i=0; world[i]!=null; i++){
                if(world[i].getName().equals(world[currRoom].firstOpt.getDestination())){
                  currRoom=i;
                  System.out.println(world[currRoom].firstDes.getItem());
                  break;
                }
              }
            }
            //prints current room's options
            z='a';
            curr=world[currRoom].firstOpt;
            while(curr!=null){
              System.out.println(z + " : " + curr.getD());
              curr=curr.next;
              z++;
            }
          }
        }
        else if(in=='b'){
          if(world[currRoom].firstOpt.next==null)
            System.out.println("Invalid command.");
          else{
            System.out.println("You " + world[currRoom].firstOpt.next.getD());
            if(world[currRoom].firstOpt.next.getDestination()!=null){
              for(int i=0; world[i]!=null; i++){
                if(world[i].getName().equals(world[currRoom].firstOpt.next.getDestination())){
                  currRoom=i;
                  world[currRoom].printAllDes();
                  break;
                }
              }
            }
            z='a';
            curr=world[currRoom].firstOpt;
            while(curr!=null){
              System.out.println(z + " : " + curr.getD());
              curr=curr.next;
              z++;
            }
          }
        }
        else if(in=='c'){
          if(world[currRoom].firstOpt.next.next==null)
            System.out.println("Invalid command.");
          else{
            System.out.println("You " + world[currRoom].firstOpt.next.next.getD());
            if(world[currRoom].firstOpt.next.next.getDestination()!=null){
              for(int i=0; world[i]!=null; i++){
                if(world[i].getName().equals(world[currRoom].firstOpt.next.next.getDestination())){
                  currRoom=i;
                  world[currRoom].printAllDes();
                  break;
                }
              }
            }
            z='a';
            curr=world[currRoom].firstOpt;
            while(curr!=null){
              System.out.println(z + " : " + curr.getD());
              curr=curr.next;
              z++;
            }
          }
        }
        else if(in=='d'){
          if(world[currRoom].firstOpt.next.next.next==null)
            System.out.println("Invalid command.");
          else{
            System.out.println("You " + world[currRoom].firstOpt.next.next.next.getD());
            if(world[currRoom].firstOpt.next.next.next.getDestination()!=null){
              for(int i=0; world[i]!=null; i++){
                if(world[i].getName().equals(world[currRoom].firstOpt.next.next.next.getDestination())){
                  currRoom=i;
                  world[currRoom].printAllDes();
                  break;
                }
              }
            }
            z='a';
            curr=world[currRoom].firstOpt;
            while(curr!=null){
              System.out.println(z + " : " + curr.getD());
              curr=curr.next;
              z++;
            }
          }
        }
        else if(in=='e'){
          if(world[currRoom].firstOpt.next.next.next.next==null)
            System.out.println("Invalid command.");
          else{
            System.out.println("You " + world[currRoom].firstOpt.next.next.next.getD());
            if(world[currRoom].firstOpt.next.next.next.getDestination()!=null){
              for(int i=0; world[i]!=null; i++){
                if(world[i].getName().equals(world[currRoom].firstOpt.next.next.next.getDestination())){
                  currRoom=i;
                  world[currRoom].printAllDes();
                  break;
                }
              }
            }
            z='a';
            curr=world[currRoom].firstOpt;
            while(curr!=null){
              System.out.println(z + " : " + curr.getD());
              curr=curr.next;
              z++;
            }
          }
        }
        //for the restart command
        else if(in=='r'){
          //sets current room to first room
          currRoom=0;
          //prints descriptions in first room
          world[currRoom].printAllDes();
          //prints options in first room
          z='a';
          curr=world[currRoom].firstOpt;
          while(curr!=null){
            System.out.println(z + " : " + curr.getD());
            curr=curr.next;
            z++;
          }
          //resets history
          historyf.next.prev=null;
          historyf.next=null;
          historyL=historyf;
        }
        //for the undo command
        else if(in=='z'){
          //set room to be room you were previously in
          if(historyL.prev!=null){
            historyL=historyL.prev;
            currRoom=historyL.getItem();
            //print descriptions of current room
            world[currRoom].printAllDes();
            //print options of current room
            z='a';
            curr=world[currRoom].firstOpt;
            while(curr!=null){
              System.out.println(z + " : " + curr.getD());
              curr=curr.next;
              z++;
            }
          }
          //for if you are in the original first room
          else System.out.println("Action cannot be undone.");          
        }
        //for the info command
        else if (in=='y'){
          for(int i=0; world[i]!=null; i++){
            System.out.println(world[i].getName());
            world[i].printAllOpt();
          }
        }
        else System.out.println("Please enter a valid command.");
        
        //add current room to room history if undo wasn't used
        if(in!='z' && in!='r' && in!='y'){
          Dllist x=new Dllist(currRoom);
          historyL.next=x;
          x.prev=historyL;
          historyL=x;
        }
        
      }
    }
  }
}


class Room{
  private String name=null;
  //for descriptions
  public Node firstDes=null;
  private Node currDes=null;
  //for options
  public Onode firstOpt=null;
  private Onode currOpt=null;
  
  //constructor
  Room(String name) {
    this.name = name;
  }
  
  //add description to room
  void addDes(String x){
    Node n=new Node(x);
    if(firstDes==null){
      firstDes=n;
      currDes=n;
    }
    else{
      currDes.next=n;
      currDes=n;
    }  
  }
  //add option to room
  void addOpt(String x){
    Onode n= new Onode(x);
    if(firstOpt==null){
      firstOpt=n;
      currOpt=n;
    }
    else{
      currOpt.next=n;
      currOpt=n;
    }
  }
  //add destination tag to most recent option
  void addTag(String x){
    currOpt.addDestination(x);
  }
  String getName(){
    return name;
  }
  void printAllDes(){
    Node search=firstDes;
    while(search!=null){
      System.out.println(search.getItem());
      search=search.next;
    }
  }
  void printAllOpt(){
    Onode search=firstOpt;
    while(search!=null){
      search.printOpt();
      search=search.next;
    }
  }
}

//simple queue for descriptions
class Node{
  public Node next;
  private String item;
  
  Node(String x){
    item=x;
  } 
  String getItem(){
    return item;
  }
}

//simple queue for room transfer history
class Dllist{
  public Dllist next;
  public Dllist prev;
  private int item;
  
  Dllist(int x){
    item=x;
  }
  int getItem(){
    return item;
  }
}

//more complicated queue for options
class Onode{
  public Onode next;
  private String description;
  private String destination;
  
  //constructor
  Onode(String description){
    this.description=description;
  }
  
  void addDestination(String x){
    destination=x;
  }
  String getD(){
    return description;
  }
  void printD(){
    System.out.println(description);
  }
  String getDestination(){
    return destination;
  } 
  void printOpt(){
    System.out.println("   " +description + " - " + destination);
  }
}
