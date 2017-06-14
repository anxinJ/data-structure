package simple.sort.homework;

import simple.sort.SortBase;
import utils.PrintUtil;

/**
 * 奇偶排序
 * 第一趟对奇数数据项对(eg.a[3] a[4])进行比较交换,第二趟对偶数数据项对(eg.a[2] a[3])进行比较交换
 * 重复进行这2趟排序,直至全部有序
 *
 * 奇偶排序在多处理器环境下很有用,处理分别同时处理每一个奇数对,然后又同时处理每个偶数对.
 * 因为奇数对都是彼此独立,每一对可以用不同处理器进行处理
 */
public class OldEvenSort extends SortBase{

    public void sort(int[] nums) {
        int scanCount = 0;
        int swapCount = 1;
        while(swapCount != 0) {
            swapCount = 0;
            // 奇数数据项扫描
            for (int i = 1; i < nums.length; i = i + 2) {
                swapCount += compareAndSwap(nums, i);
            }
            // 偶数数据项扫描
            for (int i = 0; i < nums.length; i = i + 2) {
                swapCount += compareAndSwap(nums, i);
            }
            scanCount += 2;
        }
        System.out.println(OldEvenSort.class.getName() + " scanCount : " + scanCount);
    }

    private int compareAndSwap(int[] nums, int i) {
        int swapCount = 0;
        if((i+1) < nums.length) {
            if (nums[i] > nums[i + 1]) {
                swap(nums, i, i + 1);
                swapCount++;
            }
        }
        return swapCount;
    }

}
