//Luke Lai    	Gabriel Reyes
//luelai	ghreyes
//133154	1348575
//11/17/14
//Queue.java
//creates a queue for the lines

import java.util.Iterator;
import java.util.NoSuchElementException;

class Queue <Item> implements Iterable <Item> {
  
  private class Node {
    Item item;
    Node next;
  }
  private Node head = null;
  private Node tail = null;
  
  public boolean isempty() {
    if(head==null && tail==null)
      return true;
    return false;
  }
    
  public void insert(Item newitem) {
    if(head==null && tail==null){
      Node x= new Node();
      head=x;
      tail=x;
      x.item=newitem;
      x.next=null;
    }
    else{ 
      Node x=new Node();
      tail.next=x;
      x.item=newitem;
      tail=x;
    }
  }
  
  public void printAll(Queue<Integer> q){
    Node temp=head;
    while(temp!=null){
      System.out.print(temp.item+ " ");
      temp=temp.next;
    }
  }
  
  public Iterator <Item> iterator() {
    return new Itor ();
  }
  
  class Itor implements Iterator <Item> {
    Node current = head;
    public boolean hasNext() {
      return current != null;
    }
    public Item next() {
      if (! hasNext ()) throw new NoSuchElementException();
      Item result = current.item;
      current = current.next;
      return result;
    }
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
  
}
