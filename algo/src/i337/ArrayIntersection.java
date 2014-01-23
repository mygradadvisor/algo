package i337;
import java.util.*;
public class ArrayIntersection {
	public static void main(String[] args){
		int[] A = {0,1,4,5,7,9,10,13,29,29,21};
		int[] B = {2,7,9,10,13,29};
		int n1= A.length;
		int n2 =B.length;
		
		//List<Integer> l = new ArrayList<Integer>();
		int begin =-1;
		int end =-1;
		int i=0;
		int j=0;
		int k=0;
		int maxL = n1>n2? n2:n1;
		//System.out.println(Integer.toString(maxL));
		while( i<n1 && j<n2){
			if(A[i]<B[j]){
				if(begin>-1) {
					end=i;
					break;
				}
				i++;
			}
			else if (A[i]>B[j]){
				if(begin>-1) {
					end=i;
					break;
				}
				j++;
			}
			else{ //A[i]==B[j]
				end=i;
				if(begin ==-1) begin =i;
				i++; j++;
			}
			k++;
		}
		System.out.println(Integer.toString(begin));
		System.out.println(Integer.toString(end));
		}
}
