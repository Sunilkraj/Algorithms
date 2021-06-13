package learn.ds.arrays;

import java.util.Arrays;

class RemoveDuplicates {
	
	public void removeDuplicates(int arr[]) {
		Arrays.sort(arr);
		int prev = arr[0];
		int res[] = new int[arr.length];
		res[0] = prev;
		
		for (int i = 1; i < arr.length; i++) {
			if (prev != arr[i]) {
				res[i] = arr[i];
			}
			prev = arr[i];
		}
		
		System.out.print("After removing duplicates:");
		for (int i = 0; i < res.length; i++) {
			System.out.print(" "+res[i]);
		}
		System.out.println();
	}
}
public class RemoveAllDuplicates {
	public static void main(String args[]) {
		int arr[] = {1,2,3,5,3,7,7,7,-1,-1};
		RemoveDuplicates rd = new RemoveDuplicates();
		rd.removeDuplicates(arr);
	}
}
