package permuations;

public class PermuationAndCombination {
	public static void main(String[] args){
		PermuationAndCombination pm = new PermuationAndCombination();
		
		String str = "12365";
		//System.out.println(pm.perm2("",str));
		pm.combination("",str);
	}
	
	// You could have directly called from main instead of perm1
	public void perm1(String str){
		perm2("", str);
	}
	
	//??? Can DFS give all possible permutation????
		
	//find biggest number
	//It creates a tree with root as ""; as many child of root as the elements in string.
	//Each leaf of this tree flungs out as many child as the loop's counter
	//at the end, the leaf nodes will start returning their values to the 
	//parent, that is the parent will receive a value for each loop
	//and it can decide on max
	public int perm2(String prefix, String str){
		int n = str.length();
		int max=0;
		if(n==0) {
			//max=Math.max(new Integer(prefix), max);
			return new Integer(prefix);
			
		}
		for(int i=0; i<n; i++){
			//System.out.println(Integer.toString(i));
			int tmp = perm2(prefix+str.substring(i,i+1), str.substring(0,i)+str.substring(i+1));
			max=Math.max(max, tmp);
		}
		return max;
		
	}
	
	//One branch has an element and the other does not
	
	public void combination(String soFar, String orig){
		int n = orig.length();
		if(n==0){
			//return soFar;
			System.out.println(soFar);
		}
		
		else{
			//The first element is the final combination
			//first one has element 0
			//second one does not
			combination(soFar+orig.substring(0,1), orig.substring(1));
			combination(soFar, orig.substring(1));
			
		}
	}
}
