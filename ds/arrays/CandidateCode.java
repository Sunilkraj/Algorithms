package learn.ds.arrays;

/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;
public class CandidateCode {
   public static void main(String args[] ) throws Exception {

	   //Write code here
	   BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
	   String virusComposition = b.readLine();
	   int numberOfPeople = b.read();
	   String bloodCompositions[] = new String[numberOfPeople];
	   
	   for(int i = 0; i < numberOfPeople; i++){
		   bloodCompositions[i] = b.readLine();
	   }
	   b.close();
	   
	   int len = virusComposition.length();
	   int j = 0;
	   char[] vc = virusComposition.toCharArray();
	   char[] bc = null;
	   for (int i = 0; i < len; i++) {
		   bc = bloodCompositions[j].toCharArray();
		   
		   if (vc[i] == bc[j]) {
			   j++;
			   continue;
		   }
	   }

   }
}
