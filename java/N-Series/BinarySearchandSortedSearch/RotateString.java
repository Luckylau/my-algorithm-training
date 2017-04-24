/**
 * Given a string and an offset, rotate string by offset. (rotate from left to right)
 * Example
 * Given "abcdefg".
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 * Challenge 
 * Rotate in-place with O(1) extra memory.
 * 
 * 
 */
package chapter2;

import java.util.Arrays;

public class RotateString {
	
	public void rotateString(char[] str, int offset) {
        // write your code here
        if ( str == null || str.length == 0) {
            return ;
        }
        int len = str.length;
        offset %= len;
        reverse ( str , 0, len - offset -1);
        reverse ( str , len - offset, len -1);
        reverse ( str , 0, len -1);
    }
    
    private void reverse(char[] str ,int start ,int end ) {
        while ( start < end ) {
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start++;
            end--;
        }
    }
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char [] str = new char [] {'a','b','c','d','e','f','g'};
		RotateString rotateString = new RotateString();
		rotateString.rotateString(str, 2);
		System.out.println(Arrays.toString(str));
	}

}
