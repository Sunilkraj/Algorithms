package learn.ds.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

class FindAllDuplicate{
	//Solution 1 - Use brute force with two loops
	//Solution 2 - Use HashMap => put to hashmap with key as arr element and keep counter as value.
	//Solution 3 - Use Set as set does not store dups, but while add check if it returns false then duplicate exists.
	
	public void FindDuplicateElementsUsingHashMap(int arr[]){
		 HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
		 int count = 0;
		 
		 for (int ele : arr) {
			 if (map.containsKey(ele)) {
				 count = map.get(ele);
				 map.put(ele, count + 1);
			 }else {
				 map.put(ele, 1);
			 }
		 }
		 
		 for(Entry<Integer, Integer> entry: map.entrySet()) {
			 if (entry.getValue() > 1) {
				 System.out.println("Duplicates are : "+entry.getKey());
			 }
		 }
	}
	
	public void FindDuplicateElementsUsingSet(int arr[]){
		HashSet<Integer> set = new HashSet<Integer>();
		 int count = 0;
		 System.out.print("Duplicates are :");
		 for (int ele : arr) {
			 if (set.add(ele) == false) {
				 System.out.println(ele);
			 }
		 }
	}
	
}
public class FindAllDuplicateElements {

	public static void main(String[] args) {
		int arr[] = {1,2,3,5,3,7,7,7,-1,-1};
		FindAllDuplicate dups = new FindAllDuplicate();
		dups.FindDuplicateElementsUsingHashMap(arr);
		dups.FindDuplicateElementsUsingSet(arr);
	}

}
