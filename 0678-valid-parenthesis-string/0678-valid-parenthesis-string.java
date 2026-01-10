class Solution {
    public boolean checkValidString(String s) {

        int low = 0, high = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                low++;
                high++;
            }
            else if(ch == ')'){
                low--;
                high--;
            }
            else{ //
                low--;
                high++;

            }
            if(high < 0) return false;
            if(low < 0) low = 0;
        }
        return low == 0;





         //brute force
        /*Map<Character, Integer> map = new HashMap<>();
        
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        }
       // int diff = Math.abs(map.get('(') - map.get(')'));
       int open = map.getOrDefault('(', 0);
       int close = map.getOrDefault(')', 0);
       int star = map.getOrDefault('*', 0);
       
       int diff = Math.abs(open - close);


        if(open != close){
            if(diff > star) return false;
        }
        return true;*/
        
    }
}