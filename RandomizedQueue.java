import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;
import java.lang.UnsupportedOperationException;



public class RandomizedQueue<Item> implements Iterable<Item>{
 private int size;
 
 private Item[] a = (Item[]) new Object[1];

 public RandomizedQueue(){
  size = 0;

 }
 public boolean isEmpty() {return size == 0;}
 
 public int size() {return size;}
 
 public Item dequeue(){
     if(isEmpty()){
         throw new NoSuchElementException("Its Empty");
     }
     
     int randindex;
     randindex = StdRandom.uniform(size);
     Item item = a[randindex];
     a[randindex]= a[--size];
     a[size] = null;
     if(size > 0 && size == a.length/4) resize(a.length/2);
     return item;
 }
 public void enqueue(Item item){
  if(item == null) throw new IllegalArgumentException();
  if( size == a.length) resize( 2* a.length);
   a[size++] = item;
 }
 public Item sample(){
     if(isEmpty()) throw new NoSuchElementException("Its Empty");
     int rand = StdRandom.uniform(size);
     return a[rand];
     
 }
 private void resize(int max){
     
     Item[] temp = (Item[]) new Object[max];
     for(int i = 0; i< size; i++){
         temp[i] = a[i];
     }
     a  = temp;
     
 }
 
 public Iterator<Item> iterator(){
     return new RandomizedQueueIterator();
 }
 
 private class RandomizedQueueIterator implements Iterator<Item>{
     private int i=0;
     private int[] index_array = new int[size];



      public void remove(){
      throw new java.lang.UnsupportedOperationException();
    }


      public boolean hasNext(){ return i < size;}
      
      public Item next(){
          if(i < size || size ==0 ) throw new NoSuchElementException();
          if(i==0){
            for(int j = 0; j<size; j++){
              index_array[i] = j;
            }
            StdRandom.shuffle(index_array);
          }
          return a[index_array[i++]];
      }
     

 }
}
