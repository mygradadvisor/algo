package Sorting;

public class SortingStub {
	public static void main(String[] args){
		//int[] test = {2,1,-1,3,-9,2,4,1};
		int[] test = {-2,1,-1};
		SortingAlgorithms sa = new SortingAlgorithms();
//		int[] test1=sa.mergeSort(test);
//		for(int i: test1) System.out.println(i);
		sa.quicksort(test);
	}
}
