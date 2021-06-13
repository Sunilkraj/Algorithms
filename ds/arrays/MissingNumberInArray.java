package learn.ds.arrays;

import java.util.BitSet;

class MissingNumber {
	//Sum of N sequential integers = n(n+1)/2
	//Iterate over array to find the missing element, if sorted.
}

class MissingNumbers {
	//If sorted array
	public void printMissingNumber(int [] arr, int count) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int j = 0;
		for (int i = 1; i <= count; i++) {
			if (arr[j] != i) {
				System.out.println("Missing elemt is "+i);
				i++;
			}
			j++;
		}
	}
	
	public void printMissingNumberNonSorted(int arr[], int count) {
		int [] temp = new int[count];
		
		for (int i = 0; i < arr.length; i++) {
			temp[arr[i]-1] = 1;
		}
		
		for (int i = 0; i < arr.length; i++) {
			//System.out.println("temp ["+i+"]="+temp[i]);
			if (temp[i] == 0) {
				System.out.println("Non Sorted Missing element is "+(i+1));
			}
		}
	}
	
	public void printMissingNumberUsingBitSet(int arr[], int count) {
		int missingCount = count - arr.length;
		BitSet bitSet = new BitSet(count);
		
		for (int num : arr) {
			bitSet.set(num - 1);
		}
		
		int lastMissingIndex = 0;
		for (int i = 0; i < missingCount; i++) {
			lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
			System.out.println("Last Missing index = "+ ++lastMissingIndex);
		}
	}
	
	
}

public class MissingNumberInArray {
	
	public static void main(String args[]) {
		MissingNumbers mns = new MissingNumbers();
		int [] arr = {1,2,4,5,6,8,9,10};
		mns.printMissingNumber(arr, 10);
		mns.printMissingNumberNonSorted(arr, 10);
		mns.printMissingNumberUsingBitSet(arr, 10);
	}
}
