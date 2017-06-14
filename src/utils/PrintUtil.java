package utils;

import com.sun.tools.javac.util.StringUtils;

import java.util.Arrays;

/**
 * Created by hewj on 17/6/13.
 */
public class PrintUtil {

    public static void print(int[] nums){
        print(null, nums, null);
    }

    public static void print(String startWith, int[] nums, String endWith){
        if(startWith != null && !"".equals(startWith)) {
            System.out.print(startWith);
        }
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]);
            if(i != nums.length-1){
                System.out.print(",");
            }
        }
        if(endWith != null && !"".equals(endWith)) {
            System.out.print(endWith);
        }
        System.out.println();
    }
}
