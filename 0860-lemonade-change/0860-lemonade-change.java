class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<n; i++){
            if(bills[i] == 5){
                map.put(5, map.getOrDefault(5, 0)+1);
  
            }
            if(bills[i] == 10){
                if(map.getOrDefault(5, 0) < 1) return false;
                map.put(5, map.get(5)-1);
                map.put(10, map.getOrDefault(10, 0)+1);
                
                
            }
            if(bills[i] == 20){

                if(map.getOrDefault(5, 0) > 0 && map.getOrDefault(10, 0) > 0){
                    map.put(10, map.get(10)-1);
                    map.put(5, map.get(5)-1);

                }
                else if(map.getOrDefault(5, 0) >= 3){
                    map.put(5, map.get(5)-3);
                }
                else{
                    return false;
                }
                map.put(20, map.getOrDefault(20, 0)+1);
               
                
               
            }
        }  
        return true;
    }
}