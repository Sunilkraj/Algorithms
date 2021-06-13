package learn.ds.arrays;

import java.util.Arrays;

class Median {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int nums1Len = nums1.length;
		int nums2Len = nums2.length;
		int mergedArray[] = new int[nums1Len + nums2Len];
		int k = 0;
		double median = 0.5f;
		int len = (nums1Len > nums2Len) ? nums1Len : nums2Len;

		for (int i = 0; i < len; i++) {
			if (i < nums1Len) {
				mergedArray[k] = nums1[i];
				k = k + 1;
			}
			if (i < nums2Len) {
				mergedArray[k] = nums2[i];
				k = k + 1;
			}
		}
		Arrays.sort(mergedArray);

		boolean odd = (mergedArray.length % 2 == 1) ? true : false;
		if (odd) {
			int idx = (mergedArray.length - 1) / 2;
			median = (double)mergedArray[idx];
		} else {
			int idx = (mergedArray.length - 1) / 2;
			median = (double)(mergedArray[idx] + mergedArray[idx + 1]) / 2;
		}

		return median;
	}
}

public class Solution{
	public static void main (String args[]) {
		Median median = new Median();
		int nums1[] = {1,2};
		int nums2[] = {3,4};
		double med = median.findMedianSortedArrays(nums1, nums2);
		System.out.println(med);
	}
}