package dp;

public class DP2 {
	public static void main(String[] args){
		DP2 dp2 = new DP2();
		dp2.makeChange(12);
	}
	
	public void maxContSubseq(){
		int[] data = {2,4,-6, 7, 4, -9};//11 {3,2,4,-10,10,10,10}
		int n = data.length;
		if(n==0) System.out.println(-1);
		int[] dp = new int[n];
		dp[0]=data[0];
		
		for(int i =1; i<n; i++){
			dp[i]=Math.max(dp[i-1]+data[i], data[i]);
		}
		
		int max=dp[0];
		for(int i=1;i<n; i++){
			max=Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

	public void makeChange(int C){
		int[] coins = {1,2,4,5};
		int n = coins.length;
		
		int[] dp = new int[C+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2; i<=C; i++){
			dp[i]=100000;
		}
		
		
		for(int i=2; i<=C; i++){
			for(int j=0; j<i; j++){
				for(int k=0; k<n; k++){
					if(j+coins[k]==i){
						dp[i]=Math.min(dp[i], dp[j]+1);
					}
				}
			}
			
		}
		
		System.out.println(dp[C]);
	}
}
