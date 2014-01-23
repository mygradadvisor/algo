package ListManipulation;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ListConversion2 {
	public static void main(String[] args){
		ListConversion2 lc2 = new ListConversion2();
		lc2.run();
	}
	
	public void run(){
		//List problems here
		// Data "C:\\personal\\workspace\\algo\\src\\ListManipulation\\data.txt";
		String fileName = "C:\\personal\\workspace\\algo\\src\\ListManipulation\\data.txt";
		String[] fileTokens = readData(fileName);
		//for(String str: fileTokens){
		//	System.out.println(str);
		//}
		//maxWordFreq(fileTokens);
		
		anagram(fileName);
	}
	
	public String[] readData(String fileName){
		ArrayList<String> dataList = new ArrayList<String>();
		try{
			BufferedReader bf = new BufferedReader(new FileReader(fileName));
			String line;
			while((line = bf.readLine())!=null){
				String[] str = line.split(" ");
				for(String s: str){
					dataList.add(s);
				}
			}
		}
		catch(IOException e){
			
		}
		
		return dataList.toArray(new String[dataList.size()]);
	}
	
	//Lesson: Sets/Maps (find the word which has maximum freq)
	public void maxWordFreq(String[] tokens){
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		
		for(String str: tokens){
			if(myMap.containsKey(str)){
				Integer i = myMap.get(str);
				i = new Integer(3);
				//myMap.put(str, i);
			}
			else{
				myMap.put(str, 1);
			}
		}
		
		for(String str: myMap.keySet()){
			System.out.println(str+" "+myMap.get(str));
		}
	}
	
	//Maps: Print Anagram
	public void anagram(String fileName){
		
		//Pattern p = Pattern.compile("\\w");
		Map<String, ArrayList<String>> myMap = new HashMap<String, ArrayList<String>>();
		try{
			
			
			BufferedReader bf = new BufferedReader(new FileReader(fileName));
			String line;
			while( (line = bf.readLine()) !=null){
				//Matcher m = p.
				String[] str = line.split(" ");
				for(String s: str){
					String sortedS = mySort(s);
					//System.out.println("Sorted s "+sortedS);
					if(myMap.containsKey(sortedS)){
						//System.out.println("Found match "+s);
						ArrayList<String> alist = myMap.get(sortedS);
						alist.add(s);
					}
					else{
						//System.out.println("No match "+s);
						ArrayList<String> alist = new ArrayList<String>();
						alist.add(s);
						myMap.put(sortedS, alist);
					}
				}
			}
		}
		catch(IOException e){
			
		}
		
		Set<String> sSet = myMap.keySet();
		for(String s: sSet){
			ArrayList<String> alist = myMap.get(s);
			for(String vals: alist){
				System.out.print(vals);
				
			}
			System.out.println();
		}
	}
	
	private String mySort(String s){
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}
