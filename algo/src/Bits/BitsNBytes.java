package Bits;
import java.io.*;
public class BitsNBytes {
	public static void main(String[] args){
		int data = 10;
		allSubsets2(8);
		setOperation(12,10);
		highLowBit(8);
		
	}
	/**
	 * Visual -> Pic of 101 and print out of 1 and 3 for it.
	 * @param elements
	 */
	public static void allSubsets2(int elements){
		for(int i=1; i< Math.pow(2, elements); i++){ // there are 2^n elements; of size 2 are 011; 101; 110
			System.out.println("New");
			System.out.println(Integer.toBinaryString(i));
			for(int j=1, x=0; j<=i; j=(j<<1), x++){ //take a 1 through the elements to find which are available
				if((i&j)==j) System.out.println(Integer.toString(x)); //for 111 it says all three elements are present; for 101 it says 0 and 2 are present
				
			}
		}
	}
	
	public static void highLowBit(int n){
		System.out.println("High/low index"+Integer.toBinaryString(n));
		int high=0, low=-1;
		for(int i=1; i<=n; i=(i<<1), high++){
			if((i&n)==i && low==-1) low=high-1;
		}
		System.out.println("High: "+Integer.toString(high)+" Low: "+Integer.toString(low));
	}
	
	public static void setOperation(int a, int b){
		//Union
		System.out.println("Union: "+Integer.toBinaryString(a|b));
		
		//Intersection
		System.out.println("Intersection: "+Integer.toBinaryString(a&b));
		
		//Negation
		System.out.println("Negative a: "+Integer.toBinaryString(~a));
		System.out.println("Negative b: "+Integer.toBinaryString(~b));
		
		//
		
	}
	
}
