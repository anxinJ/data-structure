package simple.sort;

/**
 * 选择排序
 * 不变形:比外部循环index小的数据项都是有序的
 * 与冒泡排序相同的比较次数 n*(n-1)/2
 * 交换次数比冒泡排序少,N越大,交换次数相对越少
 * O(n^2)
 */
public class SelectionSort extends SortBase{

    public void sort(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int min = i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j] < nums[min]){
                    min = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
    }
}
