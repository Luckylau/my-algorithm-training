package sort;

import java.util.Arrays;

public class BubbleSort {
	
	public void bubbleSort(int[]nums){
		if(nums.length == 0){
			return;
		}
		boolean flag = true;
		for(int i = 1 ;i < nums.length && flag; i++){
			flag =false;
			for(int j = nums.length - 1 ; j >= i ; j--){
				if(nums[j] < nums[j - 1]){
					int tmp = nums[j];
					nums[j] = nums[j-1];
					nums[j-1]=tmp;
					flag = true;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] nums = {2,1,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(nums));
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.bubbleSort(nums);
		System.out.println(Arrays.toString(nums));
		
	}

}
