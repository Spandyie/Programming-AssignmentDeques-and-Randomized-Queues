import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.lang.IllegalArgumentException;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>{

 private Node first;
 private Node last;
 private int size;

 private class Node{
  Item item;
  Node next;
  Node previous;
 }

public Deque() {
   // construct an empty deque
    size = 0;
    first = null;
    last = null;
}

 public boolean isEmpty(){ return (size == 0);}

 public int size(){ return size;}

 public void addFirst(Item item){

	  if(item == null){
	   throw new IllegalArgumentException("Error: input is not valid");
	  }

	  if(isEmpty()) {
	  	   first = new Node();
		   first.item = item;
		   first.next = null;
		   first.previous = null;
		   last = first;
	   }
    	else{
			Node Oldfirst = first;
			first = new Node();
			first.item = item;
			first.next = Oldfirst;
			Oldfirst.previous = first;
			}
			size++;
	}

 public void addLast(Item item) {

	  if(item == null){
	   throw new IllegalArgumentException("Error: input is not valid");
	  }
	    Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()){
            first = last;
            last.previous = null;
        }else{
            oldlast.next = last;
            last.previous = oldlast;
        }
        size++;
}


 public Item removeFirst(){
  if(isEmpty()){
   throw new NoSuchElementException("Empty!");

  }
  Item item = first.item;
  first = first.next;
  size--;
  if (isEmpty()){
  	last = null;
    first = null;
    }else{
    	first.previous = null;
    }
  return item;
 }
 public Item removeLast(){
  if(isEmpty()){
   throw new NoSuchElementException("Empty!");

  }
  Item item = last.item;
  last = last.previous;
   size--;
   return item;
 }
 public Iterator<Item> iterator(){ 
  return new DequeIterator();
 }

 private class DequeIterator implements Iterator<Item>{

  private Node cursor = first;
  

  public boolean hasNext(){return cursor != null;}

  public Item next(){
      if( !hasNext()){
          throw new NoSuchElementException();          
      }
      Item item = cursor.item;
      cursor = cursor.next;
      return item;
  }

  public void remove(){
      throw new java.lang.UnsupportedOperationException();
  }


 }
 public static void main(String[] args){
   
     Deque<Integer> deque = new Deque<Integer>();
      deque.addLast(0);
       deque.addLast(1);
        StdOut.println(deque.isEmpty());
        deque.addLast(3);
        StdOut.println(deque.removeFirst());
         deque.addLast(5) ;
         deque.addLast(6) ;
         deque.removeFirst();
     
}
 
 
 
}
