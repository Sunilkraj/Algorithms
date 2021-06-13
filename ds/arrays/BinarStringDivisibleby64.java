package learn.ds.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BinarStringDivisibleby64 {

	public static void main(String[] args) {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try {
			str = b.readLine();
			b.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (str.length() > 100) {
			throw new IllegalArgumentException();
		}
		char[] ch = str.toCharArray();
		for (int i = 6; i < str.length(); i++) {
			if (ch[i] == '1') {
				System.out.println("yes");
			}
		}
		
	}

}
