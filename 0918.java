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
