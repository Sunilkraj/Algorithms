package learn.ds.arrays;

class ZigZag{
	
	public void printZigZag(String s, int rows) {
		int len = s.length(), counter = 0;
		String str[] = new String[rows];
		boolean writeDown = true;
		boolean writeUp = false;
		int idx = 0;
		
		for (int i = 0; i < len; i++) {
			if (writeDown && idx < rows) {
				if (idx == -1) {
					idx = 1;
				}
				if (str[idx] == null) {
					
					str[idx] = ""+s.charAt(i);
				}else {
					str[idx] = str[idx] + s.charAt(i);
				}
				if ((idx + 1) == rows) {
					writeUp = true;
				}
				idx++;
			}else if (writeUp){
				if (idx == rows) {
					idx = idx - 2;
				}
				writeDown = false;
				
				str[idx] = str[idx] + s.charAt(i);
				if (idx == 0) {
					writeDown = true;
				}
				idx--;
			}
		}
		for (int i = 0; i < rows; i++) {
			System.out.println(str[i]);
		}
	}
	
	public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
	}
	
	public int reverse(int x) {
        long rev = 0;
        boolean isNegative = false;
        
        if (x < 0){
            isNegative = true;
            x = x * -1;
        }
        while (x != 0){
            rev = rev * 10 + (x % 10);
            x = x/10;
        }
        if(isNegative){
            rev=rev*-1;
        }
        System.out.println(rev);
        return (int)rev;
    }
}


public class PrintStrinZigZag {

	public static void main(String[] args) {
		String str = "PAYPALISHIRING";
		ZigZag z = new ZigZag();
		//String ret = z.convert(str, 4);
		//System.out.println(ret);
		z.reverse(1534236469);
	}

}
