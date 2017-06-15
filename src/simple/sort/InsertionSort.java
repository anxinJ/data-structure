package simple.sort;

import utils.PrintUtil;

import java.util.Arrays;

/**
 * 插入排序
 * 不变形:在每趟插入结束后,比外部循环index小的数据项都是有序的
 * 左边是局部有序,需要插入元素找到插入目标位置后,目标位置右边元素从最高位处逐个右移
 * 比较次数=1+2+...+n-1=(n-1)*n/2
 * 复制次数大于比较次数
 *
 * 在基本有序的情况下,几乎只需要O(n)
 * 在逆序的情况下,每次比较和移动都会执行,比冒泡排序还慢
 */
public class InsertionSort extends SortBase {

    public void sort(int[] nums) {
        // 比较次数
        int compareCount = 0;
        // 复制次数
        int copyCount = 0;
        for(int i=1;i<nums.length;i++){
            int tmp = nums[i];
            int in = i;
            while(in>0&&nums[in-1]>=tmp) {
                // in<=0 会短路,不进行比较
                if(in > 0){
                    compareCount++;
                }
                // if(nums[in-1] == tmp) tmp = -1; //置为-1后,改变容量实现去重
                nums[in] = nums[in-1];
                copyCount++;
                in--;
            }
            nums[in] = tmp;
        }
        System.out.println(InsertionSort.class.getName() + " compareCount : " + compareCount + "; copyCount" + copyCount);
    }

    public int median(int[] nums){
        int mid = 0;
        int half = nums.length/2;
        if(nums.length % 2 == 0){//偶数
            mid = half;
        }else{
            mid = half + 1;
        }
        sort(nums);
        return nums[mid];
    }

    public int[] noDups(int[] nums){
        sort(nums);
        int len = nums.length;
        int targetIndex = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                if(i > targetIndex){
                    nums[targetIndex] = nums[i];
                }
                targetIndex++;
            }else{
                len--;
            }
        }
        if(len < nums.length){
            nums = Arrays.copyOf(nums, len);
        }
        return nums;
    }

    public static void main(String[] args){
        int[] nums = {9, 3, 5, 7, 6, 4, 2, 8, 1, 0, 5, 6, 7, 3, 8, 5, 7, 8};
        InsertionSort is = new InsertionSort();
//        nums = is.noDups(nums);
//        PrintUtil.print(nums);
//        int maxSize = 50;
//        nums = new int[maxSize];
//        for(int i=0;i<maxSize;i++){
//            nums[i] = i;
//        }
//        is.swap(nums, 40, 20);
//        is.swap(nums, 30, 25);
//        is.swap(nums, 10, 0);
//        is.swap(nums, 15, 35);
//        is.swap(nums, 24, 28);
        is.sort(nums);
        PrintUtil.print(nums);
    }
}
