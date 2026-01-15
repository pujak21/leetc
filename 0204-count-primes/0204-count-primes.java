class Solution {
    public int countPrimes(int n) {
        
         if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];

        // assume all numbers are prime
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        // mark non-primes
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // count primes
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }

        return count;



        /*int cnt = 0;
        for(int i = 2; i<n; i++){
            boolean prime = true;
            for(int j = 2; j*j<=i; j++){
                if(i%j == 0){
                    prime = false;
                    break;
                }
            }
            if(prime) cnt++;
        }
        return cnt;*/
    }
}