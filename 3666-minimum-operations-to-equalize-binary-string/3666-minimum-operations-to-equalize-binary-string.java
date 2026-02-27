import java.util.*;

class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int initialZeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') initialZeros++;
        }

        if (initialZeros == 0) return 0;

        // Use TreeSets to quickly find and remove unvisited states in a range
        TreeSet<Integer> evenUnvisited = new TreeSet<>();
        TreeSet<Integer> oddUnvisited = new TreeSet<>();

        for (int i = 0; i <= n; i++) {
            if (i == initialZeros) continue;
            if (i % 2 == 0) evenUnvisited.add(i);
            else oddUnvisited.add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(initialZeros);
        
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                // Range of possible x (number of zeros to flip)
                int minX = Math.max(0, k - (n - curr));
                int maxX = Math.min(curr, k);

                // Range of next states: nextZeros = curr + k - 2*x
                // When x = maxX, nextZeros is MIN. When x = minX, nextZeros is MAX.
                int lower = curr + k - 2 * maxX;
                int upper = curr + k - 2 * minX;

                // All next states will have the same parity: (curr + k) % 2
                TreeSet<Integer> targetSet = ((curr + k) % 2 == 0) ? evenUnvisited : oddUnvisited;

                // Efficiently find and remove all unvisited states in [lower, upper]
                Integer next = targetSet.ceiling(lower);
                while (next != null && next <= upper) {
                    if (next == 0) return steps;
                    queue.add(next);
                    targetSet.remove(next);
                    next = targetSet.ceiling(lower); // Get the new smallest element >= lower
                }
            }
        }

        return -1;
    }
}