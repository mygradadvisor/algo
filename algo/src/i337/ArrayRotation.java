package i337;
//Rotate a one-dimensional array of n elements to the right by k steps.
//For instance, with n=7 and k=3, the array {a, b, c, d, e, f, g} is rotated to {e, f, g, a, b, c, d}.

public class ArrayRotation {
	public static void main(String[] args){
		String[] origArray = {"a", "b", "c", "d", "e", "f", "g"};
		int n = origArray.length;
		for(int i = 0; i<origArray.length; i++){
			String e = origArray[i];
			origArray[i]=origArray[(i+3)%n];
			origArray[(i+3)%n]=e;
		}
		for(int i = 0; i<origArray.length; i++){
			System.out.println(origArray[i]);
		}
		System.out.println(origArray);
	}
}
