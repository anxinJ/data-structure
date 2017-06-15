package codewars.kyu6;

import java.util.stream.Stream;

/**
 * The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge line. Each of them has a single 100, 50 or 25 dollars bill. A "Avengers" ticket costs 25 dollars.
 * <p>
 * Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.
 * <p>
 * Can Vasya sell a ticket to each person and give the change if he initially has no money and sells the tickets strictly in the order people follow in the line?
 * <p>
 * Return YES, if Vasya can sell a ticket to each person and give the change. Otherwise return NO.
 * <p>
 * ###Examples:
 * <p>
 * // *** Java ***
 * <p>
 * Line.Tickets(new int[] {25, 25, 50}) // => YES
 * Line.Tickets(new int []{25, 100})
 * // => NO. Vasya will not have enough money to give change to 100 dollars
 * Created by hewj on 17/6/15.
 */
public class VasyaClerk {

    public static String Tickets(int[] peopleInLine)
    {
        int[] remain = {0, 0};// store 25,50
        for(int i=0;i<peopleInLine.length;i++){
            int money = peopleInLine[i];
            if(money == 25){
                remain[0]++;
            }else if(money == 50 && remain[0] > 0){
                remain[0]--;
                remain[1]++;
            }else if((remain[1] > 0 && remain[0] > 0)
                    || remain[0] > 3){
                if(remain[1] > 0){
                    remain[0]--;
                    remain[1]--;
                }else{
                    remain[0] -= 3;
                }
            }else{
                return "NO";
            }
        }
        return "YES";
    }

}
