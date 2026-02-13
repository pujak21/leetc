import java.util.Arrays;

public class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int maxLen = 0;

        // Case 1: 1 distinct character (Longest streak)
        int streak = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) streak++;
            else streak = 1;
            maxLen = Math.max(maxLen, streak);
        }

        // Case 2: 2 distinct characters (a-b, b-c, a-c)
        maxLen = Math.max(maxLen, solveForTwo(s, 'a', 'b', 'c'));
        maxLen = Math.max(maxLen, solveForTwo(s, 'b', 'c', 'a'));
        maxLen = Math.max(maxLen, solveForTwo(s, 'a', 'c', 'b'));

        // Case 3: 3 distinct characters (a, b, c)
        maxLen = Math.max(maxLen, solveForThree(s));

        return maxLen;
    }

    private int solveForTwo(String s, char c1, char c2, char forbidden) {
        int n = s.length();
        int[] map = new int[2 * n + 1];
        Arrays.fill(map, -2); // -2 means not visited
        int offset = n;
        
        int count1 = 0, count2 = 0, res = 0;
        int lastStart = -1;
        map[offset] = -1;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == forbidden) {
                // Reset logic: character not allowed in this subset
                count1 = 0; count2 = 0;
                lastStart = i;
                // Note: We don't re-fill the array (too slow), 
                // we just treat indices <= lastStart as invalid.
                map[offset] = i; 
            } else {
                if (ch == c1) count1++;
                else if (ch == c2) count2++;

                int diff = count1 - count2;
                int prevIdx = map[diff + offset];
                
                if (prevIdx > lastStart || (diff == 0 && prevIdx == lastStart)) {
                    // Ensure both characters have appeared at least once since last reset
                    if (count1 > 0 && count2 > 0) {
                        res = Math.max(res, i - prevIdx);
                    }
                } else {
                    map[diff + offset] = i;
                }
            }
        }
        return res;
    }

    private int solveForThree(String s) {
        int n = s.length();
        // For 3 characters, we need to map (a-b) and (b-c).
        // A simple array won't work easily here, but we can use a custom fast hash table
        // or a HashMap because this is only 1 pass out of 5 total.
        java.util.HashMap<Long, Integer> map = new java.util.HashMap<>();
        map.put(0L, -1);
        int a = 0, b = 0, c = 0, res = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') a++;
            else if (ch == 'b') b++;
            else if (ch == 'c') c++;

            long key = ((long)(a - b) << 32) | ((long)(b - c) & 0xFFFFFFFFL);
            if (map.containsKey(key)) {
                int prevIdx = map.get(key);
                if (a > 0 && b > 0 && c > 0) {
                    res = Math.max(res, i - prevIdx);
                }
            } else {
                map.put(key, i);
            }
        }
        return res;
    }
}