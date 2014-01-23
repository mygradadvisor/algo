package graphs;
import java.util.Scanner;
import java.io.*;

public class GraphStub {
	public static void main(String[] args){

		GraphStub stub = new GraphStub();
		GraphAlgorithms2 g = new GraphAlgorithms2();
		stub.printAdjM(stub.getAdjM());
		g.DFS(stub.getAdjM());
		
	}
	
	public int[][] getAdjM(){
		int[][] adjM=null;
		String dataFile = "C:\\SogetiD830\\workspace\\algo\\src\\graphs\\myGraph.txt";
		BufferedReader bf=null;
		try{
			bf = new BufferedReader(new FileReader(dataFile));
			String line;
			int lineNum=0;
			while((line = bf.readLine())!=null){
				if(line.startsWith("#")) continue;
				lineNum++;
				
				//size of adjM
				if(lineNum==1){
					int nodes = Integer.parseInt(line);
					System.out.println(nodes);
					adjM=new int[nodes][nodes];
					for(int i=0;i<nodes;i++){
						for(int j=0; j<nodes; j++){
							adjM[i][j]=-1;
						}
					}
					continue;
				}
				
				//Populate adjM
				System.out.println(line);
				String[] data = line.split(" ");
				adjM[Integer.parseInt(data[0])][Integer.parseInt(data[1])]=Integer.parseInt(data[2]);
				//don't forget this one !!
				adjM[Integer.parseInt(data[1])][Integer.parseInt(data[0])]=Integer.parseInt(data[2]);
			}
			bf.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			
		}
		System.out.println(adjM[0].length);
		return adjM;
	}
	
	void printAdjM(int[][] adjM){
		int n = adjM[0].length;
		System.out.println("row is "+ Integer.toString(adjM.length));
		System.out.println("col is "+ Integer.toString(adjM[0].length));
		for(int i =0;i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(adjM[i][j]+" ");
			}
			System.out.println();
		}
	}
}
