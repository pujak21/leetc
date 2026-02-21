class Solution {


    static int findSetBit(int n){
        String binary = "";
        int setBit = 0;
        while(n > 0){
            binary = (n % 2) + binary;
            n = n/2;
        }
        for(char ch : binary.toCharArray()){
            if(ch == '1') setBit++;
        }
        return setBit;
    }

    public static int isPrime(int n){
        if(n<=1) return 0;

        for(int i = 2; i*i <= n; i++){
            if(n%i == 0) return 0;
        }
        return 1;
    }






    public int countPrimeSetBits(int left, int right) {
        int cnt = 0;

        for(int i = left; i<= right; i++){
            int oneBit = findSetBit(i);
            if(isPrime(oneBit) == 1) cnt++;
        }
        return cnt;
    }
   
}