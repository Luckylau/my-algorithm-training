/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * O(logN) time
 * For [4, 5, 1, 2, 3] and target=1, return 2.
 * For [4, 5, 1, 2, 3] and target=0, return -1.
 */
package chapter2;

public class SearchinRotatedSortedArray {
	
    public int search(int[] A, int target) {
        // write your code here
		if(A.length == 0){
			return -1;
		}
		int start = 0;
		int end = A.length -1;
		
		if(A[start] == target){
		    return start;
		}
		if(A[end] == target){
		    return end;
		}
		while (start+1 < end){
			int mid = start + (end - start)/2;
			if (A[mid] == target){
				return mid;
			}
			if (A[mid] > A[start]){
				if(A[mid] >= target && A[start] <= target){
					end=mid;
				}else{
					start=mid;
				}
			}else if (A[mid] < A[start]){
				if(A[mid] <= target && A[end] >= target){
					start=mid;
				}else{
					end=mid;
				}				
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = new int []{6,8,15,1,2,3,4};
		SearchinRotatedSortedArray searchinRotatedSortedArray = new SearchinRotatedSortedArray();
		System.out.println(searchinRotatedSortedArray.search(nums, 8));

	}

}
