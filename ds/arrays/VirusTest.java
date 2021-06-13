package learn.ds.arrays;

import java.io.IOException;
import java.util.Scanner;

public class VirusTest {

	public static void main(String[] args) throws IOException {
		System.out.println("Virus Test");
		//String res = v.checkPositiveOrNegative("ravus", "coronavirus");
		//System.out.println("report = "+res);
		
		Scanner sn = new Scanner(System.in);
		String res[] = null;
		int k = 0;
		VirusTest v =  new VirusTest();

		String virusComposition = sn.next();

		int n = sn.nextInt();
		res = new String[n];
		for (int i = 0; i < n; i++) {
			
			String bloodComposition = sn.next();
			
			res[k] = v.checkPositiveOrNegative(bloodComposition, virusComposition);
			System.out.println("report = "+res[k]);
			k++;
		}
		sn.close();
	}

	private String checkPositiveOrNegative(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		
		int i = 0; 
		int j = 0;
		
		while (j < m && i < n) {
			if (s1.charAt(j) == s2.charAt(i)) {
				j = j+1;
			}
			i = i + 1;
		}
		
		return (j == m ? "POSITIVE":"NEGATIVE");
	}
}
