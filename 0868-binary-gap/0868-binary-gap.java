class Solution {
    public int binaryGap(int n) {
        String binary = "";
        while(n>0){
            binary = (n % 2) + binary;
            n = n/2;
        }

        int l = 0, r = 0, len = 0, maxLen = 0;

        while(r< binary.length()){
            if(binary.charAt(r) == '1'){
                len = r-l;
                maxLen = Math.max(maxLen, len);
                l=r;
            }
            r++;

        }
        return maxLen;
    }
}