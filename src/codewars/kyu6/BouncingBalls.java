package codewars.kyu6;

/**
 * Created by hewj on 17/6/30.
 */
public class BouncingBalls {

    public static int bouncingBall(double h, double bounce, double window) {
        if(bounce <=0 || bounce >=1 || window >= h || h <= 0) return -1;
        int ret = 1;
        while((h *= bounce) > window){
            ret += 2;
        }
        return ret;
    }

    public static int cleverestSolution(double h, double bounce, double window) {
        if (h > 0 && 0 < bounce && bounce < 1 && window < h)
            return 1 + 2 * (int) Math.floor(Math.log(window / h) / Math.log(bounce));
        else
            return -1;
    }
}
