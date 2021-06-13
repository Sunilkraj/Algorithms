package learn.ds.arrays;

import java.util.Arrays;

class PrintPairs {
	// Solution 1: two loops with i=0,j=1 and do the sum of arr[i] + arr[j] == sum,
	// then print pairs, continue.
	// Solution 2: One loop: diff = sum - arr[i], if arr contains diff, then pair
	// exists and print the pair.
	// Sort and compare 1st with last element, if given sum is k and arr[first] +
	// arr[last] < k, then last = last+1...

	public void printPairsUsingTwoPointers(int arr[], int givenSum) {
		if (arr.length < 2) {
			return;
		}
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum == givenSum) {
				System.out.printf("(%d, %d) %n", arr[left], arr[right]);
				left = left + 1;
				right = right - 1;
			} else if (sum < givenSum) {
				left = left + 1;
			} else if (sum > givenSum) {
				right = right - 1;
			}
		}
	}
}

public class PrintPairWithMachingSum {

	public static void main(String args[]) {
		int arr[] = { 2, 4, 7, 5, 9, 10, -1 };
		PrintPairs p = new PrintPairs();
		p.printPairsUsingTwoPointers(arr, 9);
	}
}
