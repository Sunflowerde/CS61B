import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaExercises {

    /** Returns an array [1, 2, 3, 4, 5, 6] */
    public static int[] makeDice() {
        int[] dices = {1, 2, 3, 4, 5, 6};
        return dices;
    }

    /** Returns the order depending on the customer.
     *  If the customer is Ergun, return ["beyti", "pizza", "hamburger", "tea"].
     *  If the customer is Erik, return ["sushi", "pasta", "avocado", "coffee"].
     *  In any other case, return an empty String[] of size 3. */
    public static String[] takeOrder(String customer) {
        Map<String, String[]> orders = new HashMap<>();
        orders.put("Ergun", new String[]{"beyti", "pizza", "hamburger", "tea"});
        orders.put("Erik", new String[]{"sushi", "pasta", "avocado", "coffee"});
        if (customer.equals("Ergun") || customer.equals("Erik")) {
            return orders.get(customer);
        }
        return new String[3];
    }

    /** Returns the positive difference between the maximum element and minimum element of the given array.
     *  Assumes array is nonempty. */
    public static int findMinMax(int[] array) {
        int min_number = 1000000000;
        int max_number = -1000000000;
        for (int x : array) {
            if (x < min_number) {
                min_number = x;
            }
            if (x > max_number) {
                max_number = x;
            }
        }
        return max_number - min_number;
    }

    /**
      * Uses recursion to compute the hailstone sequence as a list of integers starting from an input number n.
      * Hailstone sequence is described as:
      *    - Pick a positive integer n as the start
      *        - If n is even, divide n by 2
      *        - If n is odd, multiply n by 3 and add 1
      *    - Continue this process until n is 1
      */
    public static List<Integer> hailstone(int n) {
        return hailstoneHelper(n, new ArrayList<>());
    }

    private static List<Integer> hailstoneHelper(int x, List<Integer> list) {
        list.add(x);
        while (x != 1) {
            if (x % 2 == 0) {
                x = x / 2;
            } else {
                x = x * 3 + 1;
            }
            list.add(x);
        }
        return list;
    }
}
