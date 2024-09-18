import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
//         int[] answer = new int[prices.length];
        
//         for(int i=0; i<prices.length; i++){
//             int currentNum = prices[i];
//             int cnt = 0;
//             for(int j=0; j<prices.length-i; j++){
//                 if(currentNum <= prices[i+j]){
//                     cnt++;
//                 } else {
//                     break;
//                 }
                
//                 //마지막은 0초로 계산
//                 if(i+j == prices.length-1){
//                     cnt--;
//                 }
//             }
//             answer[i] = cnt;
//         }
        int length = prices.length;
        Stack<Integer> idxStack = new Stack<>();
        int[] answer = new int[length];
        
        for(int i=0; i<length; i++){
            while(!idxStack.isEmpty() && prices[i] < prices[idxStack.peek()]){
                int idx = idxStack.pop();
                answer[idx] = i - idx;
            }
            
            idxStack.push(i);
        }
        
        while(!idxStack.isEmpty()){
            int idx = idxStack.pop();
            answer[idx] = length - 1 -idx;
        }
        
        return answer;
    }
}

/*
1. 스택으로 시간복잡도 개선
*/

import java.util.*;
class Solution {
    public int solution(int[] nums) {

        // Map<Integer, Integer> ponchetMons = new HashMap<>();
        // for(int num: nums){
        //     ponchetMons.set(num, ponchetMons.getOrDefault(num, 0)+1);
        // }

        Set<Integer> ponchetMons = new HashSet<>();
        for(int num: nums){
            ponchetMons.add(num);
        }
        int difCnt = ponchetMons.size();

        if(nums.length/2 < difCnt){
            return nums.length/2;
        } else {
            return difCnt;
        }
    }
}

// stack, hashmap 연습
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> completionMap = new HashMap<>();

        for(String comPerson: completion){
            completionMap.put(comPerson, completionMap.getOrDefault(comPerson, 0)+1);
        }

        for(String partPerson: participant){
            if(completionMap.containsKey(partPerson)){
                if(completionMap.get(partPerson) == 0){
                    return partPerson;
                }
                completionMap.put(partPerson, completionMap.get(partPerson)-1);
            } else {
                return partPerson;
            }
        }
        return answer;
    }
}
