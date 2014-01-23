package dataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Implement a PQ for a Node (need to define comparison operation)
 * @author akumar33
 *
 */
public class PriortyQueueExample {
	class Node{
		int u, cost;
		Node(int u, int cost){
			this.u =u; 
			this.cost = cost;
		}
	}
	
	class NodeComparator implements Comparator<Node>{
		public int compare(Node a, Node b){
			if (a.cost<b.cost) return -1;
			if(a.cost>b.cost) return 1;
			return 0;
		}
	}
	public static void main(String[] args){
		PriortyQueueExample pqexample =  new PriortyQueueExample();
		Comparator<Node> mycomparator = pqexample.new NodeComparator();
		PriorityQueue<Node> pq = new PriorityQueue<Node>(10, mycomparator);
		Node a = pqexample.new Node(0,10);
		Node b = pqexample.new Node(1,5);
		Node c = pqexample.new Node(2,1);
		pq.add(a);
		pq.add(b);
		pq.add(c);
		Node i = pqexample.new Node(0,0);
		while( (i = pq.poll()) != null ){
			//Node i = pq.poll();
			//if(i==null) break;
			System.out.println(i.cost);
		}
	}
	

	public void pQueue(){
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
	}
}
