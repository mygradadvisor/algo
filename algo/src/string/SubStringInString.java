package string;

// "blr" is a pattern in bangalore
public class SubStringInString {

	public static void main(String[] args){
		SubStringInString test = new SubStringInString();
		test.printIsPattern("blr", "bangalore");
	}
	
	
	public void printIsPattern(String sub, String mainStr){
		//boolean isPattern = false;
		int n = sub.length();
		int j = 0;
		for(int i=0; i<n; i++){
			while(j<mainStr.length()  && !sub.substring(i,i+1).equals(mainStr.substring(j, j+1))){
				j++;
				if(j==mainStr.length()-1){
					System.out.println("Not found");
					return;
				}
			}
			if(i==n-1){
				System.out.println("Yes");
				return;
			}
			j++;
		}
		System.out.println("Not found");
	}
}
