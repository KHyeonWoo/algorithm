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
