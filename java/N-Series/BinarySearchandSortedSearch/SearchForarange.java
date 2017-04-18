/**
 * Search for a Range
 * Given a sorted array of n integers, find the starting and ending position of a given target value.
 * If the target is not found in the array, return [-1, -1].
 * For example, 
 * Given [5, 7, 7, 8, 8, 10] and target value 8, 
 * return [3, 4].
 */
package chapter2;

import java.util.Arrays;

public class SearchforaRange {
	
    public int[] searchRange(int[] A, int target) {
        // write your code here
        if (A.length == 0){
            return new int[]{-1,-1};
        }
        int start = 0;
        int end = A.length-1;
        int [] bound = new int [2];
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(A[mid] >= target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(A[start] == target){
            bound[0] = start;
        }else if(A[end] == target){
            bound[0] = end;
        }else{
            bound[0] = bound[1] = -1;
            return bound;
        }
        start = 0;
        end = A.length-1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(A[mid] <= target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(A[end] == target){
            bound[1] = end;
        }else if (A[start] == target){
            bound[1] = start;
        }else {
            bound[0]=bound[1] = -1;
        }
        return bound;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = new int []{1,2,2,3,4};
		SearchforaRange searchforaRange=new SearchforaRange();
		System.out.println(Arrays.toString(searchforaRange.searchRange(nums, 2)));

	}

}