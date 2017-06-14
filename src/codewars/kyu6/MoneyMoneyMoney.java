package codewars.kyu6;

/**
 * Mr. Scrooge has a sum of money 'P' that wants to invest, and he wants to know how many years 'Y' this sum has to be kept in the bank in order for this sum of money to amount to 'D'.
 * <p>
 * The sum is kept for 'Y' years in the bank where interest 'I' is paid yearly, and the new sum is re-invested yearly after paying tax 'T'
 * <p>
 * Note that the principal is not taxed but only the year's accrued interest
 * <p>
 * Example:
 * <p>
 * Let P be the Principal = 1000.00
 * Let I be the Interest Rate = 0.05
 * Let T be the Tax Rate = 0.18
 * Let D be the Desired Sum = 1100.00
 * <p>
 * <p>
 * After 1st Year -->
 * P = 1041.00
 * After 2nd Year -->
 * P = 1083.86
 * After 3rd Year -->
 * P = 1128.30
 * Thus Mr. Scrooge has to wait for 3 years for the initial pricipal to ammount to the desired sum.
 * <p>
 * Your task is to complete the method provided and return the number of years 'Y' as a whole in order for Mr. Scrooge to get the desired sum.
 * <p>
 * Assumptions : Assume that Desired Principal 'D' is always greater than the initial principal, however it is best to take into consideration that if the Desired Principal 'D' is equal to Principal 'P' this should return 0 Years.
 * Created by hewj on 17/6/14.
 */
public class MoneyMoneyMoney {

    public static int calculateYears(double principal, double interest,  double tax, double desired) {
        int year = 0;
        while(principal < desired){
            principal += principal*interest*(1-tax);
            year++;
        }
        return year;
    }

    public static int cleverest(double principal, double interest,  double tax, double desired) {
        return (int) Math.ceil(Math.log(desired / principal) / Math.log(1 + interest * (1 - tax)));
    }
}
