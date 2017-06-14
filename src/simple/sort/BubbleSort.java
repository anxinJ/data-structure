package simple.sort;


import utils.PrintUtil;

/**
 * 冒泡排序
 * 不变形:比外部循环index大的数据项都是有序的
 * 比较次数=(n-1+n-2+...+2+1)=n*(n-1)/2~=(n^2)/2
 * 交换次数为0到比较次数之间,一半时为(n^2)/4
 * O(n^2)
 */
public class BubbleSort extends SortBase{

    public void sort(int[] nums){
        for(int i=nums.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(nums[j] > nums[j+1]){
                    int tmp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args){
        int maxSize = 10000;
        int[] nums = new int[maxSize];
        long startTime = System.currentTimeMillis();
        for(int i=0;i<maxSize;i++){
            nums[i] = (int)(Math.random() * (maxSize-1));
        }
        new BubbleSort().sort(nums);
        PrintUtil.print(nums);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime));
    }
}
