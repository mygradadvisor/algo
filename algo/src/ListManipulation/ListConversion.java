package ListManipulation;
import java.io.*;
import java.util.*;

public class ListConversion {
	public static void main(String[] args){
		//Read data in array
		String fileName="C:\\personal\\workspace\\algo\\src\\ListManipulation\\data.txt";
		String[] data = readData(fileName);
		
		//Arrays Sort
		Arrays.sort(data);
		
		//Sets: word with maximum frequency
		maxFreqWord(data);
		
		//Maps: print Anagram
		printAnagram(data);
		for(String s: data)
			System.out.println(s);
	}
	
	//Lesson: return an Array even though the elements being read are are stored in arraylist.
	public static String[] readData(String fileName){
		//http://download.oracle.com/javase/tutorial/essential/io/file.html
		List<String> fileTokens= new ArrayList<String>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line=null;
			//construct: reading from a file
			while((line=br.readLine())!=null){
				//creating a bigger array out of smaller arrays
				// dont use array; use a collection
				String[] elements = line.split(" ");
				for(String s: elements){
					fileTokens.add(s);
				}
				
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		//convert Collection to Array
		String[] tokens = new String[fileTokens.size()];
		return  fileTokens.toArray(tokens);
	}
	
	//Lesson: Sets/Maps (find the word which has maximum freq)
	public static void maxFreqWord(String[] data){
		int max=0;
		Set<String> myset = new HashSet<String>();
		int cnt =0;
		String maxword=null;
		for(String s: data){
			if(!myset.add(s)) cnt++;
			else{
				if(cnt>max) {
					max=cnt;
					maxword=s;
				}
				cnt=0;
			}
		}
		System.out.println(maxword+": "+Integer.toString(max));
		
	}
	
	//AutoBoxing in Map
	//http://docs.oracle.com/javase/1.5.0/docs/guide/language/autoboxing.html
	// Note when you are dealing Integers, you have to put it back in the map
	// but when you have an arraylist, putting back on map is not required
	//Maps: Print Anagram
	public static void printAnagram(String[] data){
		Map<String, ArrayList<String>> res = new HashMap<String, ArrayList<String>>();
		for(String s: data){
			String sortedS = mysort(s);
			if (!res.containsKey(sortedS)){
				ArrayList<String> newList = new ArrayList<String>();
				newList.add(s);
				res.put(sortedS,newList);
			}
			else{
				ArrayList<String> myList = res.get(sortedS);
				myList.add(s);
				//res.put(sortedS,myList); //NOT REQUIRED !!!
				
			}
		}
		//Lesson: how to iterate a map (one can use for-next construct as well)
		int n = res.size();
		for(int i =0; i<n ; i++){
			Set<String> myset = res.keySet();
			for(String s: myset){
				System.out.println(res.get(s));
			}
		}
	}
	
	public static String mysort(String s){
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(s);
		// c.toString() does not work
	}
}
