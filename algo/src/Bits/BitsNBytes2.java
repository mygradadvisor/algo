package Bits;

/** Print all subsets for n=4 */
public class BitsNBytes2 {
	public static void main(String[] args){
		
		BitsNBytes2 test = new BitsNBytes2();
		test.allSubsets(3);
		//test.allSubsets2(3);
		
	}
	
	void allSubsets(int n){
		for(int i =1; i<Math.pow(2,n); i++){
			System.out.println(Integer.toBinaryString(i));
			for(int j=1, x=1;j<=i; j=(j<<1), x++ ){
				if(j==(i&j)) System.out.println(x);
			}
		}
	}

}
