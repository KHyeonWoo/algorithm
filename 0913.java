import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothesMap = new HashMap<>();

        for(int idx = 0; idx < clothes.length; idx++){
            int cnt = clothesMap.getOrDefault(clothes[idx][1], 0);
            clothesMap.put(clothes[idx][1],cnt+1);
        }
        Collection<Integer> categoryCnt = clothesMap.values();
        for(int cnt: categoryCnt){
            answer *= (cnt+1);
        }

        return answer-1;
    }
}

/*
1. HashMap .values() 를 쓰면 Collection 형태 -> forEach 문으로 접근하기!!
*/

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        //Arrays.sort 는 Integer 형 내림차순 불가능
        // ArrayList<Integer> sortedCit = new ArrayList<>();
        // for(int num: citations){
        //     sortedCit.add(num);
        // }
        // Collections.sort(sortedCit,Collections.reverseOrder());
        
//         for(int i=0; i<citations.length; i++){
//             if(i+1 > citations[i]){
//                 answer = i;
//                 break;
//             }
            
//             // 끝까지 순회했을 때, i + 1이 sortedCit.get(i)보다 크지 않은 경우
//             answer = i + 1; 
//         }
         for(int i=0; i<citations.length; i++){
            if(citations.length-i <= citations[i]){
                answer = citations.length-i;
                break;
            }
            
        }
        
        return answer;
    }
}
/*
1. Arrays.sort() -> Array , Collections.sort() -> List
2. Arrays.sort() 는 Integer 내림차순 불가능, 나머지는 Collections 내림차순이랑 동일한 방법
*/
