package ListManipulation;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Practice {
	public static void main(String[] args){
		String filename="C:\\personal\\workspace\\algo\\src\\ListManipulation\\data.txt";
		String[] tokens = readDoc(filename);
		for(String s: tokens){
			System.out.println(s);
		}
		

	}
	
	public static String[] readDoc(String filename){
		List<String> lstr = new ArrayList<String>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			while((line = br.readLine()) != null){
				String[] elements = line.split(" ");
				for(String s: elements){
					lstr.add(s);
				}
				
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		String[] a = new String[lstr.size()];
		return lstr.toArray(a);
	}
}
