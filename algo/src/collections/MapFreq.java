package collections;
import java.util.*;

public class MapFreq {
	public static void main(String[] args){
		Map<String, Integer> m = new LinkedHashMap<String, Integer>();
		for(String s: args){
			if(m.containsKey(s)) m.put(s,m.get(s)+1);
			else m.put(s, new Integer(1));
		}
		System.out.println(m);
		//Iterate over keys
		
		//iterate over values
		
	}
}
