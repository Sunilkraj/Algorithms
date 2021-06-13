package learn.ds.arrays;

class LargetsAndSmallest{
	
	public void getLargestAndSmallestElement(int [] arr) {
		if (arr == null || arr.length == 1) {
			System.out.println("Invalid Array");
			return;
		}
		int largest = arr[0];
		int smallest = arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < smallest) {
				smallest = arr[i];
			}
			
			if (arr[i] > largest) {
				largest = arr[i];
			}
		}
		
		System.out.println("Largest = "+largest+" Smallest = "+smallest);
	}
} 

public class FindLargestnSmallest {

	public static void main(String[] args) {

		LargetsAndSmallest ls = new LargetsAndSmallest();
		int arr[] = {-20, 34, 21, -87, 92, 2147483647};
		ls.getLargestAndSmallestElement(arr);
	}

}
