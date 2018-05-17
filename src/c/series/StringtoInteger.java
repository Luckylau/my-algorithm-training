package c.series;

/**
 * 
 */
public class StringtoInteger {
	public int myAtoi(String str) {
		if (str.length() == 0 || str == null) {
			return 0;
		}
		boolean postive = true;
		int start = 0;
		if (str.charAt(start) == ' ') {
			while (str.charAt(start) == ' ') {
				start++;
				if (start >= str.length()) {
					return 0;
				}
			}
		}
		if (str.charAt(start) == '-') {
			System.out.println("==============");
			postive = false;
			start++;
		} else if (str.charAt(start) == '+') {
			start++;
		} else if (str.charAt(start) >= '0' && str.charAt(start) <= '9') {
			return cal(str, start, true);
		} else {
			return 0;
		}
		if (start >= str.length()) {
			return 0;
		}
		if (str.charAt(start) < '0' || str.charAt(start) > '9') {
			return 0;
		} else {
			return cal(str, start, postive);
		}
	}

	private int cal(String str, int start, boolean postive) {
		long res = 0;
		while (start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9') {
			res = res * 10 + str.charAt(start) - '0';
			if (postive) {
				if (res > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				}
			} else {
				if (-res < Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
			}
			start++;
		}
		if (postive) {
			return (int) res;
		} else {
			return (int) -res;
		}
	}

	public static void main(String[] args) {
		String s = "9223372036854775809";
		StringtoInteger stringtoInteger = new StringtoInteger();
		System.out.println(stringtoInteger.myAtoi(s));

	}

}
