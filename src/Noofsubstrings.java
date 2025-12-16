public class Noofsubstrings {

    public static int numberOfSubstrings(String s) {
        int count = 0;
        int[] lastSeen = { -1, -1, -1 };

        for (int r = 0; r < s.length(); r++) {
            lastSeen[s.charAt(r) - 'a'] = r;

            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count += 1 + Math.min(
                        lastSeen[0],
                        Math.min(lastSeen[1], lastSeen[2])
                );
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abcabc";

        int result = numberOfSubstrings(s);
        System.out.println("Number of substrings containing a, b, and c: " + result);
    }
}

