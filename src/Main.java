import java.util.HashMap;
import java.util.Map;

class Solution {

    public int totalFruit(int[] fruits) {

        int left = 0;
        int maxLen = 0;
        Map<Integer, Integer> basket = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {

            int fruit = fruits[right];
            basket.put(fruit, basket.getOrDefault(fruit, 0) + 1);

            // If more than 2 types of fruits, shrink the window
            while (basket.size() > 2) {
                int leftFruit = fruits[left];
                basket.put(leftFruit, basket.get(leftFruit) - 1);

                if (basket.get(leftFruit) == 0) {
                    basket.remove(leftFruit);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] fruits = {1, 2, 1, 2, 3};
        System.out.println(sol.totalFruit(fruits));
    }
}
