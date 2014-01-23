package Sorting;

public class SortingAlgorithms {
	
	//can be a type instead of array
	public int[] mergeSort(int[] list){
		int n = list.length;
		if (n==1) return list;
		
		int[] left= new int[n/2];
		int[] right = new int[n-n/2]; //eg: 3-1
		for(int i=0; i<n/2; i++ ){
			left[i]=list[i];
			//right[i]= list[n-1];
		}
		for(int i=n/2, j=0; i<n; i++, j++ ){
			right[j]=list[i];
			//right[i]= list[n-1];
		}		
		left=mergeSort(left);
		right=mergeSort(right);
		for(int i: left) System.out.println(i);
		for(int i: right) System.out.println(i);
		return merge(left, right);
		
	}
	
	public int[] merge(int[] left, int[]  right){
		//important - how else you would save the merged list
		int m =0;
		int[] merged = new int[left.length+right.length];
		
		int l = 0;
		int r = 0;
		while (l<left.length || r<right.length){
			System.out.println("while loop");
			System.out.println("l: "+Integer.toString(r));
			if(l < left.length && r < right.length){
				if(left[l] < right[r]) {
					//increment counters are assigning
					merged[m++]=left[l++];
				}
				else{
					merged[m++]=right[r++];
				}
				//else{
					//merged[m++]=left[l++];
				//}
			}
			//else if(l<left.length && right.length==r){
			else if(l<left.length){
				merged[m++] = left[l++];
			}
			else if (r<right.length){
				merged[m++] = right[r++];
			}
		}
		
		return merged;
	}
	
	//QUICKSORT
	//Remeber you pass array variables as parameter, so you dont have to create multiple arrays.
	public int[] quicksort(int[] list){
		int n = list.length;
		if(n<=1) return list;
		
		//always choose pivot as first element
		//int pivotIndex = 0;
		int lo=0;
		int hi = n-1;
		sort(list, lo, hi);
		for(int i: list){
			System.out.println(Integer.toString(i));
		}
		return list;
	}
	
	private void sort(int[] list,  int lo, int hi){
		//System.out.println(Integer.toString(lo));
		//System.out.println(Integer.toString(hi));
		if(lo>=hi) return;
		//int n = list.length;
		int j = partition(list, lo, hi);
		
		//j is my pivot index
		sort(list, lo, j-1);
		sort(list, j+1, hi);
	}
	
	private int partition(int[] list, int lo, int hi){
		// lo will be pivot index
		int pi = lo;
		int i = lo+1;
		int j=hi;
		while(i<j){
			while(list[i]<list[pi]) {
				i++;
				if(i==hi) break;
				
			}
			
			while(list[j]>list[pi]) {
				j--;
				if(j==lo) break;
				
			}
			
			if(i<j) swap(list, i, j);
		}
		
		swap(list, lo, j);
		return i;
	}
	
	private void swap(int[] list, int i, int j){
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
}
