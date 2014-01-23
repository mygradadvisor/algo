package dp;

/*------------- DP from MIT
 * ------------ http://people.csail.mit.edu/bdean/6.046/dp/
 * 
 */
public class DP {

	public static void main(String[] args){
		int maxContSub = maxContinousSubseq();
		System.out.println(maxContSub);
		
		int makeChange = makeChange(21);
		System.out.println("MakeChange: "+ Integer.toString(makeChange));
		
		int longestIncSubseq = longestIncSubseq();
		System.out.println("longestIncSubseq: "+Integer.toString(longestIncSubseq));
	}
	/*
	 * -----Given a sequence of n real numbers A(1) ... A(n), 
	 * -----determine a contiguous subsequence A(i) ... A(j) 
	 * -----for which the sum of elements in the subsequence is maximized.
	 */
	public static int maxContinousSubseq(){
		int[] data = {2,4,-6, 7, 4, -9};//11 {3,2,4,-10,10,10,10}
		int n = data.length;
		if(n==0) return -1;
		
		int[] dp = new int[n];
		dp[0]=data[0];		
		for(int i =1; i<n; i++){
			dp[i]=Math.max(dp[i-1]+data[i], data[i]);
		}
		
		int max=dp[0];
		for(int i=1;i<n; i++){
			max=Math.max(max, dp[i]);
		}
		return max;
	}
	}
	
	/*
	 * ---- Making Change
	 * ----You are given n types of coin denominations of values v(1) < v(2) < ... < v(n) (all integers). 
	 *----- Assume v(1) = 1, so you can always make change for any amount of money C. 
	 *----- Give an algorithm which makes change for an amount of money C with as few coins as possible.
	 */
	
	public static int makeChange(int C){
		int[] coins = {1,2,4,5};
		/*
		 * --dp[] stores two pieces of information
		 * --index is the sum and value is count of 
		 * --coins
		 */
		int[] dp = new int[C+1];
		
		dp[0]=0;
		for(int i=1; i<=C; i++) dp[i]=1000; 
		for(int i=2; i<=C; i++){ // is the current sum/count
			for(int j =0; j<i; j++){
				for(int ccount = 0; ccount<coins.length; ccount++){
					if(coins[ccount]+j==i)
					dp[i] = Math.min(dp[j]+1, dp[i]);
					
				}
			}
		}
		return dp[C];
		
	}
	
	/*
	 * -- Longest Increasing Subsequence
	 * --Given a sequence of n real numbers A(1) ... A(n), determine a 
	 * --subsequence (not necessarily contiguous) of maximum length in 
	 * --which the values in the subsequence form a strictly increasing 
	 * --sequence.
	 * --eg: {5,3,-2,4,5,2,9,3} = 4 {1,6 }
	 */
	public static int longestIncSubseq(){
		int[] subseq = {5,3,-2,4,5,2,9,3,-6};
		int n = subseq.length;
		int[] dp = new int[n];
		
		dp[0]=1;
		for(int i=1; i<n; i++){
			int max = 0;
			for(int j=0; j<n-1; j++){
				if(subseq[i]>subseq[j]){
					max = Math.max(max, dp[j]);
				}
				
			}
			dp[i] = max+1;
		}
		int res=0;
		for(int i=0; i< n; i++){
			System.out.println(Integer.toString(dp[i]));
			res = Math.max(res, dp[i]);
		}
		return res;
	}
	
	/*
	 * ---Building Bridges
	 * ---Consider a 2-D map with a horizontal river passing through its center. 
	 * ---There are n cities on the southern bank with x-coordinates a(1) ... a(n)
	 * --- and n cities on the northern bank with x-coordinates b(1) ... b(n).
	 * ---You want to connect as many north-south pairs of cities as possible with
	 * --- bridges such that no two bridges cross. When connecting cities, you 
	 * ---can only connect city i on the northern bank to city i on the southern bank. 
	 */
	public int buildingBridges(){
		
	}
}
 