import java.util.*;

class N2Ngi {
    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int x : arr) {
            // check if x is double of some number OR
            // if half of x already exists (important for even numbers)
            if (set.contains(2 * x) || (x % 2 == 0 && set.contains(x / 2))) {
                return true;
            }
            set.add(x);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 5, 3};
        System.out.println(checkIfExist(arr)); // true (5 and 10)
    }
}
