package simple.sort;

import utils.ClassUtil;
import utils.PrintUtil;

import java.util.List;

/**
 *
 */
public abstract class SortBase{

    public abstract void sort(int[] nums);

    public void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        List<Class> children = ClassUtil.getSubClassesByParent(SortBase.class);
        for(Class child : children) {
            int[] nums = {9, 3, 5, 7, 6, 4, 2, 8, 1, 0};
            SortBase sortBase = (SortBase)child.newInstance();
            sortBase.sort(nums);
            PrintUtil.print("the sorted result of " + child.getName() + " : ", nums, ".");
//            int maxSize = 50000;
//            int[] nums = new int[maxSize];
//
//            for(int i=0;i<maxSize;i++){
//                nums[i] = (int)(Math.random() * (maxSize-1));
////                nums[i] = maxSize - i - 1;
////                nums[i] = i;
//            }
//            long startTime = System.currentTimeMillis();
//            SortBase sortBase = (SortBase)child.newInstance();
//            sortBase.sort(nums);
////            PrintUtil.print(nums);
//            long endTime = System.currentTimeMillis();
//            System.out.println(child.getName() + ":" + (endTime-startTime));
        }
    }
}
