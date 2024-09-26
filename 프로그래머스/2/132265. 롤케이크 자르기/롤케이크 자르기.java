import java.util.*;
class Solution {
    public int solution(int[] topping) {
        Set<Integer> leftSet = new HashSet<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        int cnt = 0;
        
        for(int i=0; i<topping.length; i++){
                rightMap.put(topping[i], rightMap.getOrDefault(topping[i], 0)+1);
        }
            
        for(int top: topping){
            leftSet.add(top);
            
            if(rightMap.get(top) == 1){
                rightMap.remove(top);
            } else {
                rightMap.put(top, rightMap.get(top)-1);
            }
            
            if(leftSet.size() == rightMap.size()){
                cnt++;
            }
        }
        return cnt;
    }
}