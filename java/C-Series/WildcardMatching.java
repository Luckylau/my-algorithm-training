package demo;

/**
 * '?' Matches any single character. '*' Matches any sequence of characters
 * (including the empty sequence). The matching should cover the entire input
 * string (not partial).
 *
 */
public class WildcardMatching {

	public boolean isMatch(String str, String pattern) {
		if (str.length() == 0 || str == null) {
			return false;
		}
		if (pattern.length() == 0 || pattern == null) {
			return false;
		}
		int s = 0;
		int p = 0;
		int match = 0;
		int startIndex = -1;
		while (s < str.length()) {
			if (p < pattern.length() && (str.charAt(s) == pattern.charAt(p) || pattern.charAt(p) == '?')) {
				s++;
				p++;
			} else if (p < pattern.length() && pattern.charAt(p) == '*') {
				startIndex = p;
				p++;
				match = s;
			} else if (startIndex != -1) {
				match++;
				s = match;
				p = startIndex + 1;

			} else {
				return false;
			}
		}
		while (p < pattern.length() && pattern.charAt(p) == '*') {
			p++;
		}
		return p == pattern.length();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcdcdcef";
		String pattern = "a*ce*f";
		WildcardMatching wildcardMatching = new WildcardMatching();
		System.out.println(wildcardMatching.isMatch(str, pattern));

	}

}
