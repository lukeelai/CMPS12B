import java.util.*;
import java.io.*;

class BusinessSearch {
  Record(String first, String second){
    name=first;
    number=second;
  }
  
  public String name;
  public String number;  
  
  static Record[] addBusiness(String name, String number, Record[] list, int i){
    Record temp = new Record(name,number);
    list[i]=temp;
    return list;
  }
  
  static Record convertToRecord(String line){
    int i=0;
    while(line.charAt(i)!=',') i++;
    return new Record(line.substring(0,i), line.substring(i+2)); 
  }
  
  static Record[] mergeSort(Record[] list) {
    //makes a String[] and fills with names from Record[] list
    String[] a=new String[list.length];
    for(int i=0; i<list.length; i++){
      a[i]=list[i].name;
    }
    
    //splits "a" and "list" into two pieces
    if (a.length >= 2) {
      String[] left = new String[a.length / 2];
      String[] right = new String[a.length-a.length / 2];
      Record[] listLeft = new Record[list.length / 2];
      Record[] listRight = new Record[list.length-a.length / 2];
      
      //fills left sides
      for (int i = 0; i < left.length; i++){ 
        left[i] = a[i];
        listLeft[i]= list[i];
      }
      
      //fills right sides
      for (int i = 0; i < right.length; i++){
        right[i] = a[i + a.length / 2];
        listRight[i] = list[i + list.length / 2];
      }
      
      //recursively splits further
      mergeSort(listLeft);
      mergeSort(listRight);
      
      merge(list, listLeft, listRight);
      
    }
    return list;
  }
  
  static void merge(Record[] list, Record[] listLeft, Record[] listRight) {
    //Carried over from mergeSort so make a String[] equivalent
    String[] a=new String[list.length];
    for(int i=0; i<list.length; i++){
      a[i]=list[i].name;
    }
    //left and right = names from listLeft and listRight
    String[] left = new String[listLeft.length];
    String[] right = new String[listRight.length];
    for (int i = 0; i < left.length; i++){
      left[i] = listLeft[i].name; 
    }
    for (int i = 0; i < right.length; i++){
      right[i] = listRight[i].name;
    }
    
    int i1 = 0;
    int i2 = 0;
    for (int i = 0; i < a.length; i++) {
      if (i2 >= right.length || (i1 < left.length && left[i1].compareToIgnoreCase(right[i2])<0)) {
        a[i] = left[i1];
        list[i]=listLeft[i1];
        i1++;
      } 
      else {
        a[i] = right[i2];
        list[i]=listRight[i2];
        i2++;
      }  
    }
  }
  
  static String booleanSearch(String b, Record[] list){
    int low=0;
    int high=list.length-1;
    
    while(high>=low && low>=0 && high<=list.length-1){
      int mid=(high+low)/2;
      if(b.compareToIgnoreCase(list[mid].name)==0){
        return list[mid].number;
      }
      if(b.compareToIgnoreCase(list[mid].name)>0){
        low=mid+1;
      }
      if(b.compareToIgnoreCase(list[mid].name)<0) {
        high=mid-1;
      }
    }  
    return "NOT FOUND";
  }
  
  
  
  
  public static void main(String[] args)throws FileNotFoundException{
    //sets the input
    Scanner input= new Scanner(System.in);
        
    //if there is no file after BusinessSearch in the command line, will print correct usage
    if(args.length==0){
      System.out.println("Usage: BusinessSearch businessDB");
      return;
    }
        
    //Imports the file to be used
    String x= args[0];
    File f= new File(x);
    Scanner file = new Scanner(new FileReader(f));

    //sets initial total queries and not found queries counts to 0
    int tq=0;
    int nfq=0;
    
    //Sets the Number of Businesses to be the first line of the file
    int numBusinesses=Integer.parseInt(file.nextLine());
    
    //creates array called LIST with size=numBusinesses
    Record[] list = new Record[numBusinesses];

    //adds businesses to list and sorts using merge sort
    for(int i=0; i<numBusinesses; i++){
      list[i]=convertToRecord(file.nextLine());
    }
    mergeSort(list);
    
    //for debugging only DELETE AFTER ASSIGNMENT IS COMPLETE ************************************************************************
    for(int i=0; i<numBusinesses; i++){
      System.out.println(list[i].name + "," + list[i].number);
    }
    
    //input for searching/ query info
    while(input.hasNextLine()){
      String cmd= input.nextLine();
      if(cmd.equals(""))
        System.out.println( tq + " total queries, " + nfq + " not found");
      else{
        String temp=booleanSearch(cmd ,list);
        if(temp.equals("NOT FOUND")){
          tq++;
          nfq++;
        }
        else tq++;
        System.out.println(temp);
      }
    }
  }
}
