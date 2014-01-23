package javaIO;
import java.io.*;

public class IOExample {
	public static void main(String[] args){
		/*------------ FILE READING IN ONE LINE---------
		 * 
		 */
		String line;
		try{
			BufferedReader bf = new BufferedReader(new FileReader("C:\\personal\\workspace\\algo\\src\\javaIO\\data.txt"));
			while(( line=bf.readLine())!=null){
				System.out.println(line);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		/*-----WRITING OUT A FILE
		 * 
		 */
		BufferedWriter bw = null;
		try{
			bw = new BufferedWriter(new FileWriter("C:\\personal\\workspace\\algo\\src\\javaIO\\dataOutput.txt"));
			
			BufferedReader bf = new BufferedReader(new FileReader("C:\\personal\\workspace\\algo\\src\\javaIO\\data.txt"));
			while(( line=bf.readLine())!=null){
				bw.write(line);
				bw.newLine();
			}
			System.out.println("Completed writing data");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				/** ------ if you don't close it, you actually don't get the entire file ----- only 643K**/
				/** ------ Seems like you dont really have to flush, but you MUST close -------------****/
				bw.flush();
				bw.close();				
			}
			catch(Exception e){
				e.printStackTrace();
			}

		}
		
		/** ------------------------ JAVA 7 has Path class ---------- *********/
		
		/** -------------------- Java.io.file has been improved in java.nio.file ------------**/
		
		/** -------http://docs.oracle.com/javase/tutorial/essential/io/legacy.html ----***/
		
		/* ----------------------- LIST ALL FILES IN A DIR --------------- */
		File f = new File("C:\\personal\\workspace\\algo\\src\\javaIO");
		if (f.isDirectory()){
			System.out.println(f.getAbsolutePath() + " is a directory");
			String[] files = f.list();
			for(String s: files){
				System.out.println(s);
			}
		}
	}
	
	
}
