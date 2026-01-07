public class LengthOfLastWordMain {

    public static int lengthOfLastWord(String s) {
        String[] words = s.trim().split("\\s+");
        int n = words.length;
        String t = words[n - 1];

        int i = 0;
        int cnt = 0;

        while (i < words[n - 1].length()) {
            cnt++;
            i++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s = "   Hello World   ";

        int result = lengthOfLastWord(s);

        System.out.println(result);
    }
}
