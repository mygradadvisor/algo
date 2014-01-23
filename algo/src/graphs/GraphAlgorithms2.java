package graphs;
import java.awt.List;
import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.ArrayList;

public class GraphAlgorithms2 {

	class Node{
		private int i;
		Node(int i){
			this.i=i;
		}
	}
	class Edge{
		private Node i,j;
		
	}
	public class Graph{
		private int[][] adjM;
		public Graph(int[][] adjM){
			this.adjM=adjM;
		}
	}
	
	/**
	 * DFS
	 */
	public void DFS(int[][] adjM){
		int n  = adjM[0].length;
		Stack<Integer> st = new Stack<Integer>();
		int[] visited = new int[n];
		visited[0]=1;
		for(int i=1; i<n; i++) visited[i]=-1;
		st.push(0);
		
		while(!st.isEmpty()){
			Integer u = st.pop();
			visited[u]=1;
			int[] row = adjM[u];
			for(int v=0; v<n; v++){
				if( row[v]==1 && visited[v]==-1){
					st.push(v);
					//visited[v]=1;
					
				}
			}
		}
		for(int i=0; i<n; i++){
			System.out.println(Integer.toString(visited[i])+" ");
		}
	}
}
 