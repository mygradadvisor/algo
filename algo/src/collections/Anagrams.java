package collections;
import java.io.*;
import java.util.*;

public class Anagrams {
	public static void main(String[] args){
		Map<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		for(int i=0; i<args.length; i++){
			String w = sort(args[i]);
			if(hm.containsKey(w)) {
				ArrayList<String> l= hm.get(w);
				l.add(w);
				hm.put(w, l);
			}
			else{
				ArrayList<String> l = new ArrayList<String>();
				l.add(args[i]);
				hm.put(w, l);
			}
		}
		//System.out.println(hm);
		for(ArrayList a : hm.values()){
			System.out.println(a);
		}
		
	}
	
	public static String sort(String str){
		char[] c = str.toCharArray();
		Arrays.sort(c);
		return c.toString();
	}
}
