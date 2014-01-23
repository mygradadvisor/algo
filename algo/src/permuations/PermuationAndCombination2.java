package permuations;

import java.io.*;
import java.util.*;
public class PermuationAndCombination2 {
	public static void main(String[] args){
	
		String str = "abc";
		permutation1("", str);
	}
	
	public static void permutation1(String prefix, String str){
		int n = str.length();
		if(n==0) {
			System.out.println(prefix);
			return;
		}
		
		for(int i=0; i<n; i++){
			permutation1(prefix+str.substring(i,i+1), str.substring(0,i)+str.substring(i+1,n));
		}
		//System.out.println(prefix);
	}
}
