// Luke Lai Gabriel Reyes
// 1355154 1348575
// luelai ghreyes
// 10/29/14
// dllist.java
// Template code for doubly-linked list of strings.
import java.util.*;

public class dllist {

   	public enum position {FIRST, PREVIOUS, FOLLOWING, LAST};

   	private class node {
      		String item;
      		node prev;
      		node next;
   	}

   	private node first = null;
   	private node current = null;
   	private node last = null;
	private int currentPosition = 0;
	private int size = 0;
   	
	public void setPosition (position pos) {
      		if(isEmpty())
			return;
		if(pos == position.FIRST){
			current = first;
			currentPosition = 1;
   		}
		if(pos == position.PREVIOUS){
			if(current.prev == null)
				return;
				current = current.prev;
				currentPosition--;
		}
		if(pos == position.FOLLOWING){
			if(current.next == null)
				return;
				current = current.next;
				currentPosition++;
		}
		if(pos == position.LAST){
			current = last;
			currentPosition = size;
		}
	}

  	public boolean isEmpty () {
      		if(first == null && last == null)
			return true;
		return false;
   	}

   	public String getItem () {
		if(isEmpty())
	      		throw new UnsupportedOperationException();
		return current.item;
   	}

   	public int getPosition () {
		if(isEmpty())
      			throw new NoSuchElementException();
		return currentPosition;
   	}

   	public void delete () {
		if(isEmpty())
	      		throw new NoSuchElementException();
		if(size == 1){
			first = null;
			current = null;
			last = null;
			currentPosition = 0;
			size = 0;
		}else{
			if(current != first)
				current.prev.next = current.next;
			if(current == last){
				current = current.prev;
				currentPosition--;
			}else{
				current.next.prev = current.prev;
				current.next = current;
			}
			size--;
		}
   	}

   	public void insert (String item, position pos) {
		if(isEmpty() && (pos == position.FIRST || pos == position.LAST)){
			node n = new node();
			n.item = item;
			n.next = null;
			n.prev = null;
			first = n;
			last = n;
			current= n;
			currentPosition++;
		}else if(isEmpty() && (pos == position.FOLLOWING || pos == position.PREVIOUS))
			throw new IllegalArgumentException();
			else{
			if(pos == position.FIRST){
				node n = new node();
				n.item = item;
				n.next = first;
				first.prev = n;
				first = n;
				current = n;
				currentPosition = 1;
		}
		if(pos == position.PREVIOUS){
			node n = new node();
			n.item = item;
			n.next = current;
			n.prev = current.prev;
			if(current != first){
				current.prev.next = n;
		}else 
			first = n;
			current.prev = n;
			current = n;
		}
		if(pos == position.FOLLOWING){
			node n = new node();
			n.item = item;
			n.prev = current;
			n.next = current.next;
			if(current != last){
				current.next.prev = n;
			}else
			last = n;
			current.next = n;
			current = n;
			currentPosition++;
		}
		if(pos == position.LAST){
			node n = new node();
			n.item = item;
			n.prev = last;
			last.next = n;
			last = n;
			current = n;
			currentPosition = size + 1;
		}
	}
	size++;
	}
}
