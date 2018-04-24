/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume NO duplicates in the array.
 * 
 * O(log(n)) time
 * Example
 * [1,3,5,6], 5 �� 2
 * [1,3,5,6], 2 �� 1
 * [1,3,5,6], 7 �� 4
 * [1,3,5,6], 0 �� 0
 */
package n.series.BinarySearchandSortedSearch;

public class SearchInsertPosition {
	
	public int searchInsert(int[] nums , int target){
		if (nums.length == 0){
			return 0;
		}
		int start = 0;
		int end = nums.length-1;
		if ( nums[start]>= target){
			return start;
		}
		if ( nums[end]< target){
			return end + 1;
		}
		if (nums[end]==target){
			return end;
		}
		
		while(start + 1< end){
			int mid = start + (end - start)/2;
			if (nums[mid] == target){
				return mid;
			}else if (nums[mid] > target){
				end = mid;
			}else if ( nums [mid] < target){
				start = mid; 
			}
		}
		
		return start+1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = new int []{1,2,6,8,15};
		SearchInsertPosition searchInsertPosition =new SearchInsertPosition();
		System.out.println(searchInsertPosition.searchInsert(nums, 9));

	}

}