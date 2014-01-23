package graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

// Source: Algorithms by Vazirani
// Sedgewick: http://algs4.cs.princeton.edu/24pq/
public class GraphAlgorithms {
/*********************** REPRESENTATIONS ***************
 * 
 */

	/**
	 * Imagine Node/Edge representation as a single edge (u,v) with cost 3.
	 */
// NODE

	class Node{
		private final int u;
		public Node(int val){
			this.u=val;
		}
	}
//EDGE
	class Edge implements Comparable<Edge>{
		private int u, v, cost;
		public Edge(int u , int v, int cost){
			this.u = u;
			this.v = v;
			this.cost = cost;
			
		}
		
		public int node1(){
			return u;
		}
		
		public int otherNode(int node1){
			if(node1==u) return v;
			else if(node1==v) return u;
			else return -1;
		}
		
		public int cost(){
			return cost;
		}
		
		public int compareTo(Edge e){
			if (this.cost < e.cost) return -1;
			else if(this.cost == e.cost) return 0;
			else return 1;
		}
	}
	
	//Graph - Vertices and Edges; Adjacency Matrix and Adjacency List representation.
	//Don't need this class if we have an adjacency matrix/adjacency list - all info is in the DS
	
	//Graph based on adjacency Matrix
	class Graph{
		private int[][]adjM;
		//TC representation - a matrix 
		public Graph(int[][] adjM){
			this.adjM=adjM;
		}
		
		public boolean isConnected(int u, int v){
			if(adjM[u][v] ==1) return true;
			return false;
		}
		
		
	}
	
	//************************* UNION FIND  **********************
	// - Detect a cycle
	// Visual Code - should give the data structure needed
	// Couple of segments - {A,B} and {C,D,E} with A and C repsective parents
	// When merged, {A,B} will be merged with {C,D,E}
	// Data structures that can be found: total elements, the one at the top in
	// each segment, total segments
	class UnionFind{
		int count; //total elements
		//top level parent point to themselves
		int[] parent;
		//sz needed to figure out which set to attach to.
		int[] sz;
		List<Node> nodes;
		public UnionFind(int N){ //N is the node
			count = N;
			//start with each element parents of its own
			for(int i=0; i<N; i++){
				parent[i]=i;
				sz[i]=1;
			}
		}
		
		
//		public void makeset(Node u, Node v){ //E={u,v}
//			if(find(u) ==-1 && find(v)==-1){
//				
//				
//			}
//		}
		
		public boolean connected(int u , int v){
			if (find(u)==find(v)) return true;
			return false;
		}
		public void union(int p, int q){
			if(find(p)==find(q)) return;
			if(sz[p]<sz[q]){
				parent[p]=find(q);
				sz[q]+=sz[p];
			}
			else{
				parent[q] = find(p);
				sz[p]+=sz[q];
			}
			count--;
		}
		
		//return parent; parent always point to themselves
		//find is usually not called by outside function
		public int find(int x){
			while(x!=parent[x]){
				x=parent[x]; // go up in the chain
			}
			return x;
		}
	}
	
	/**
	 * 
	 * --- Kruskal - Repeatedly add the next lightest edge that does not produce a cycle
	 *
	 */
	class Kruskal{
		public Kruskal(ArrayList<Edge> edges, int vertices){
			List<Edge> mstQ = new ArrayList<Edge>();
			int mstWeight=0;
			UnionFind UF = new UnionFind(edges.size());
			
			Collections.sort(edges);
			
			//Keep adding edges till e=v-1 && you dont form a cycle
			while(edges.size()>=vertices-1 && edges.size()>0){
				//regardless of whether this edge is used, it will be removed.
				Edge e = edges.remove(0);
				int u = e.node1();
				int v = e.otherNode(u);
				
				if (!UF.connected(u,v)){
					UF.union(u,v);
					mstQ.add(e);
					mstWeight+=e.cost();
				}
				
			}
		}
	}
	
	//Vazirani
	//MST will be contained in prev
	
	class Vertex implements Comparable<Vertex>{
		int id;
		double cost;
		
		public Vertex(int id){
			this.id=id;
		}
		
		public double getCost(){
			return cost;
		}
		public void setCost(double cost){
			this.cost=cost;
		}
		
		public int compareTo(Vertex u){
			if (this.cost<u.cost) return -1;
			else if (this.cost==cost) return 0;
			else return -1;
		}
	}
	
	class Prim{
		int mstWeight = 0;
		List<Edge> mstEdges = new ArrayList<Edge>();
		
		public Prim(ArrayList<Edge> edges, ArrayList<Vertex> vertices){
			double[] cost = new double[vertices.size()];
			int[] prev = new int[vertices.size()];
			
			//TreeSet<Integer> pq = new TreeSet<Integer>();
			PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(); 
			for(int i=0; i<vertices.size(); i++){
				Vertex u = vertices.get(i);
				u.setCost(Double.POSITIVE_INFINITY);
				pq.add(u);
			}
			
			//might as well start at 0
			prev[0]=0;
			
			ArrayList<Integer> nodesInMST = new ArrayList<Integer>();
			nodesInMST.add(new Integer(0));
			
			while (pq.size()>0){
				Vertex u = pq.poll();
				for(Edge e: edges){
					int v_id = e.otherNode(u.id);
					if(v_id>-1){
						Vertex v = vertices.get(v_id);
						if(v.cost>e.cost){
							v.setCost(e.cost);
							prev[v.id]= u.id;
						}
					}
				}
				
			}
		}
	}
	
	//**********    DFS
	
	public class DFS{
		
		
		public DFS(Graph G, int u){
			int[][] adjM = G.adjM;
			
			int n = adjM[0].length;
			
			int[] visited = new int[n];
			for(int i=0; i<n; i++) visited[i]=-1;
			//What does visited do for you in DFS
			visited[u]=1;
			
			Stack<Integer> st = new Stack<Integer>();
			
			st.push(u);
			while(!st.isEmpty()){
				int u1 = st.pop();
				int[] urow = adjM[u1];
				for(int i=0; i< urow.length; i++){
					if(urow[i]==0) continue;
					if(visited[i]==-1){
						st.push(i);
						visited[i]=1;
					}
				}
			}
			
		}
	}
	
	public void dfs(String u){
		//create the adjacency matrix
		int nodes=0;
		int[][] adjM=null;
		try{
			BufferedReader bf = new BufferedReader(new FileReader("C:\\personal\\workspace\\algo\\src\\graphs\\myGraph.txt"));
			boolean firstLine=true;
			String line = null;
			while((line = bf.readLine())!=null){
				if(!line.startsWith("#")){
					if(firstLine){
						firstLine = false;
						nodes = Integer.parseInt(line);
						adjM = new int[nodes][nodes];
						continue;
					}
				}
				
				String[] edges = line.split(" ");
				if(!line.startsWith("#") && edges.length==3){
					//System.out.println(Integer.parseInt(edges[0])+ " " +Integer.parseInt(edges[1])+ " "+Integer.parseInt(edges[2]));
					adjM[Integer.parseInt(edges[0])][Integer.parseInt(edges[1])] = Integer.parseInt(edges[2]);
					
				}
				
			}			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		// I have my adjM now
		int[] visited = new int[nodes];
		for(int i=0; i< visited.length; i++)
			visited[i]=-1;
		
//		for(int i=0; i< adjM.length; i++){
//			for(int j=0; j< adjM[0].length; j++){
//				System.out.println("adjM "+Integer.toString(i)+ " "+Integer.toString(j)+ " "+Integer.toString(adjM[i][j]));
//			}
//		}
		Stack<Integer> st = new Stack<Integer>();
		st.add(Integer.parseInt(u));
		visited[Integer.parseInt(u)]=1;
		while(!st.empty()){
			int u1 = st.pop(); 
			int[] adjMRow = adjM[u1];
			for(int v =0; v< adjMRow.length; v++){
				if(adjM[u1][v]>0 && visited[v]!=1){
					visited[v]=1;
					st.push(v);
				}
			}
		}
		for(int i=0; i< nodes; i++){
			System.out.println(Integer.toString(i)+ " "+Integer.toString(visited[i]));
		}
	}	
	//******************  BFS
	
	public class BFS{
		
		public BFS(Graph G, int s){
			int[][] adjM = G.adjM;
			int[] dist = new int[adjM[0].length];
			for(int i=0; i< dist.length; i++) dist[i]=-1;
			Queue<Integer> q = new Queue<Integer>();

			q.add(s);
			dist[s]=0;
			
			while(!q.isEmpty()){
				
				int u = q.dequeu();
				
				int[] urow = adjM[u];
				
				for(int i=0; i<urow.length; i++){
					
					if(urow[i]==1 && dist[i]==-1){
						dist[i]=dist[u]+1;
						q.add(i);
						//visited[u]
					}
				}
			}
		}
	}
	
	//******************** DIJKSTRA
	
	public class Dijkstra{
		//s is source or starting point
		public Dijkstra(Graph G, int s){
			int[][] adjM = G.adjM;
			
			int n = adjM[0].length;
			int[] dist = new int[n];
			int[] prev = new int[n];
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			for(int i=0; i<n; i++){
				dist[i]=-1;
				prev[i]=-1;
				pq.add(i);   // unlike BFS - all elements are added just now
			}
			
			
			pq.add(s);
			dist[s]=0; //;subtle - doing this will make it the first to be taken out
			prev[s]=-1; // or 0 ?
			
			while(!pq.isEmpty()){
				int u = pq.remove();
				int[] urow = adjM[u];
				
				for(int i =0; i< urow.length; i++){
					if(urow[i]!=0){
						if(dist[i]>dist[u]+urow[i] ){
							dist[i] = dist[u]+urow[i];
							updatePQ; // make sure PQ rearranges
							prev(i) = u;
						}
					}
				}
			}
		}
	}
 }
