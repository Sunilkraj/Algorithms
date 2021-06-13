package learn.ds.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumInRangeTest {
	boolean primeNumber[] = new boolean[1000001];

	void findPrimes() {
		Arrays.fill(primeNumber, Boolean.TRUE);
		for (int i = 2; i * i < 100001; i++) {
			if (primeNumber[i]) {
				for (int j = i + i; j < 100001; j += i)
					primeNumber[j] = false;
			}
		}
	}

	int findPrimeInRange(int l, int r) {

		int lPrime = 0;
		int rPrime = 0;
		for (int i = l; i <= r; i++) {
			if (primeNumber[i] == true) {
				lPrime = i;
				break;
			}
		}
		for (int j = r; j >= l; j--) {
			if (primeNumber[j] == true) {
				rPrime = j;
				break;
			}
		}
		
		if (rPrime == 0 && lPrime == 0) {
			return -1;
		}
		return (rPrime - lPrime);
	}

	public static void main(String[] args) {
		
		PrimeNumInRangeTest p = new PrimeNumInRangeTest();
		p.findPrimes();
		Scanner sn = new Scanner(System.in);
		
		int n = sn.nextInt();
		
		for (int i = 0; i < n; i++) {
			int lRange = sn.nextInt();
			int rRange = sn.nextInt();
			
			int res = p.findPrimeInRange(lRange, rRange);
			System.out.println(res);
		}
		sn.close();
	}

}
