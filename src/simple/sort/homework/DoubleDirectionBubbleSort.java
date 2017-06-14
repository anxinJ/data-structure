package simple.sort.homework;

import simple.sort.SortBase;

/**
 * 双向移动冒泡排序,当最大达到最右端时,反向,把最小移到左端
 *
 */
public class DoubleDirectionBubbleSort extends SortBase{

    public void sort(int[] nums){
        int min = 0;
        int max = nums.length-1;
        while(min < max){
            for(int i=min;i<max;i++){
                if(nums[i] > nums[i+1]){
                    int tmp = nums[i+1];
                    nums[i+1] = nums[i];
                    nums[i] = tmp;
                }
            }
            max--;
            for(int i=max;i>0;i--){
                if(nums[i-1] > nums[i]){
                    int tmp = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = tmp;
                }
            }
            min++;
        }
    }
}
