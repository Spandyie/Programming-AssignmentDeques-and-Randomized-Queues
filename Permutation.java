import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
public class Permutation{
    public static void main(String[] args){
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> input_array = new RandomizedQueue<String>();
        while( ! StdIn.isEmpty()){
             String ss = StdIn.readString();
             input_array.enqueue(ss);       
        }
        
        for( int i=0; i < k; i++){
            StdOut.println(input_array.dequeue());
        
        }
    }
}

