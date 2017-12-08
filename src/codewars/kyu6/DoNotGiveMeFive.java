package codewars.kyu6;

/**
 * Created by hewj on 17/6/15.
 */
public class DoNotGiveMeFive {

    public static int noFive(int start, int end){
        int count = 0;
        for(int i=start;i<=end;i++){
            if(String.valueOf(i).contains("5")){
                count++;
            }
        }
        return count;
    }

}
