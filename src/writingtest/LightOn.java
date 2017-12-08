package writingtest;

/**
 * 滴滴2016研发笔试题
 * 2015盏灯，一开始全部熄灭，序号分别是1-2015，先把1的倍数序号的灯的开关全部按一次，
 * 然后把2的倍数的灯的开关全部按一次，然后把3的倍数的开关按一次，以此类推，最后把2015
 * 的倍数灯的开关按一次。问最后亮着的灯有多少盏？
 * A43 B44 C45 D46
 * Created by hewj on 17/9/25.
 */
public class LightOn {

    /** 分析
     1) 1: 1 亮
        2: 1 3 5 7 9 亮
        3: 1 3 5 6 7 亮
        结论:1的倍数只有1,只点击1次常亮;点击奇数次会亮==>找出能被奇数个正整数整除的数

     2) 1: 1 亮
        2: 1 2
        3: 1 3
        4: 1 2 4 亮
        5: 1 5
        6: 1 6
        7: 1 7
        8: 1 2 4 8
        9: 1 3 9 亮
        ...
        16: 1 2 4 8 16 亮
        结论:1 4 9 16 25 ... ==>  1^2 2^2 3^2 4^2 即求一个最大的数,该数的平方数不大于2015

     */

    public static int lightOnNum(int i){
        int count = 0;
        for(i = 1; i<=2015; i++){
            if(i * i <= 2015){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}
