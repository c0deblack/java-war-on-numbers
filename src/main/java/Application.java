import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * There's a great war between the even and odd numbers.
 * Many numbers already lost their lives in this war and it's your task to end this.
 * You have to determine which group sums larger: the evens, or the odds. The larger group wins.
 * <br><br>
 * Create a function that takes an array of integers, sums the even and odd numbers separately,
 * then returns the difference between the sum of the even and odd numbers.
 * <br><br>
 * <p>Examples</p>
 * <p>warOfNumbers([2, 8, 7, 5]) ➞ 2</p>
 * // 2 + 8 = 10 <br>
 * // 7 + 5 = 12<br>
 * // 12 is larger than 10<br>
 * // So we return 12 - 10 = 2<br>
 * warOfNumbers([12, 90, 75]) ➞ 27<br>
 * warOfNumbers([5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243]) ➞ 168<br>
 * Notes<br>
 * The given array contains only positive integers.
 */
public class Application {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter any number of integers separated by spaces and then press CTRL+D or enter any non integral character surrounded by spaces to end input");
        System.out.println(warOnNumbers(getIntArrayFromStdin(sc)));
    }

    public static int warOnNumbers(int ...i){
        int oddSum = Arrays.stream(i).filter(oddCheck::isOdd).reduce(0, Integer::sum);

        int evenSum = Arrays.stream(i).filter(evenCheck::isEven).reduce(0, Integer::sum);

        return Math.abs(oddSum - evenSum);
    }

    public static int[] getIntArrayFromStdin(Scanner sc){
        List<Integer> input = new ArrayList<Integer>();

        while ( sc.hasNext() ){
            if (sc.hasNextInt() ){
                input.add( sc.nextInt() );
            } else {
                break;
            }
        }
        return input.stream().mapToInt(Integer::intValue).toArray();
    }

    private static class evenCheck {
        public static boolean isEven(int i){
            return i % 2 == 0;
        }
    }

    private static class oddCheck {
        public static boolean isOdd(int i){
            return i % 2 == 1;
        }
    }
}
