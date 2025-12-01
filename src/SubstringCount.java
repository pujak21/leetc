import java.util.Scanner;

class SubstringCount {

    public int numberOfSubstrings(String s) {
        int l = 0, r = 0, count = 0;
        int[] lastSeen = { -1, -1, -1 };

        for (r = 0; r < s.length(); r++) {

            // store latest position of character a, b, or c
            lastSeen[s.charAt(r) - 'a'] = r;

            // if all have been seen at least once
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count = count + 1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string (only a, b, c): ");
        String s = sc.nextLine();

        SubstringCount obj = new SubstringCount();
        int result = obj.numberOfSubstrings(s);

        System.out.println("Number of substrings containing 'a', 'b', and 'c': " + result);

        sc.close();
    }
}

