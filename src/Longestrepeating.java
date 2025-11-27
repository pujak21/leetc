public class Longestrepeating {

    public static void main(String[] args) {
        Solution1 obj = new Solution1();

        String s = "AABABBA";
        int k = 1;

        int result = obj.characterReplacement(s, k);
        System.out.println("Longest repeating substring length: " + result);
    }
}

class Solution1 {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int l = 0, r = 0;
        int maxFreq = 0;
        int maxLen = 0;

        while (r < s.length()) {

            hash[s.charAt(r) - 'A']++; // count current character
            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']); // update most frequent char count

            // if replacement required exceeds k, shrink window from left
            if ((r - l + 1) - maxFreq > k) {
                hash[s.charAt(l) - 'A']--;
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}

