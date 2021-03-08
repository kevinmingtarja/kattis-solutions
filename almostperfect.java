import java.util.*;
import java.math.*;

public class almostperfect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            long num = sc.nextLong();
            int sumOfProperDivisors = 0;

            for (long i = 1; i <= (Math.sqrt((double)num)); i++) {
                if (num % i == 0) {
                    sumOfProperDivisors += (i + (num/i));
                }
            }
            sumOfProperDivisors -= num;
            if (sumOfProperDivisors == num){
                System.out.println(num + " perfect");
            } else if (Math.abs(sumOfProperDivisors - num) <= 2) {
                System.out.println(num + " almost perfect");
            } else {
                System.out.println(num + " not perfect");
            }
        }
    }
}
