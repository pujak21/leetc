import java.util.*;

class MaxCardPoint {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int lsum = 0, rsum = 0, maxSum = 0;

        // Step 1: Sum of first k cards
        for(int i = 0; i < k; i++){
            lsum += cardPoints[i];
        }

        maxSum = lsum;

        // Step 2: Sliding window — remove from left, add from right
        int r = n - 1;

        for(int i = k - 1; i >= 0; i--){
            lsum -= cardPoints[i];
            rsum += cardPoints[r];
            r--;

            maxSum = Math.max(maxSum, lsum + rsum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of cards
        System.out.print("Enter number of cards: ");
        int n = sc.nextInt();

        // Input: card values
        int[] cardPoints = new int[n];
        System.out.println("Enter card values:");
        for(int i = 0; i < n; i++){
            cardPoints[i] = sc.nextInt();
        }

        // Input: k value
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        MaxCardPoint obj = new MaxCardPoint();
        int result = obj.maxScore(cardPoints, k);

        System.out.println("Maximum points you can score: " + result);

        sc.close();
    }
}
