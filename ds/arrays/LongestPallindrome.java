package learn.ds.arrays;
/*
 * ex: ababad
 * ITR# begin end char[begin] char[end] begin-- end++ return substr(begin+1, end)
 *  1	  0	   0	a			b		 -1      0              a
 *  2	  1	   1	b			b		  0      2              continues
 *  	  0	   2	a			a		 -1      0              aba
 *  3     2	   2	a			a		  1      3              continue
 *  	  1	   3	b			b		  0      4				continue
 *  	  0	   4	a			a		 -1      5              ababa
 *  . . .
 *  . . .
 */
public class LongestPallindrome {
	public static void main(String[] args) {
		LongestPallindrome lp = new LongestPallindrome();
		System.out.println("Longest Palindrome- " + lp.findLongestPalindrome("ababcd"));
	}

	public String findLongestPalindrome(String str) {
		// starting point for comparison with other palindromes
		String longestPalindrome = str.substring(0, 1);
		for (int i = 0; i < str.length(); i = i + 1) {
			// odd length case (center is i)
			String newPalindrome = checkIfEqual(str, i, i);
			if (newPalindrome.length() > longestPalindrome.length()) {
				longestPalindrome = newPalindrome;
			}
			// even length case (center is i, i+1)
			newPalindrome = checkIfEqual(str, i, i + 1);
			if (newPalindrome.length() > longestPalindrome.length()) {
				longestPalindrome = newPalindrome;
			}
		}
		return longestPalindrome;
	}

	public String checkIfEqual(String str, int begin, int end) {
		while ((begin >= 0 && end <= str.length() - 1) && (str.charAt(begin) == str.charAt(end))) {
			// move left
			begin--;
			// move right
			end++;
		}
		return str.substring(begin + 1, end);
	}
}
