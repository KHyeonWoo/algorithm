import java.util.ArrayList; 

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        ArrayList<String> prev_words = new ArrayList<>(); 
        char prev_last = '\0';

        for (int i =0 ; i<words.length; i++){
            String word = words[i];
            if(i!=0 && (prev_last != word.charAt(0) || prev_words.contains(word))){
                return new int[]{i%n+1, i/n+1};
            } else {
                prev_last = word.charAt(word.length()-1);
                prev_words.add(word);
            } 
        }

        return answer;
    }
}

/* 
9월 9일 공부노트 1
1. //ArrayList 쓸거면 import 해야함 (hashset 등등 마찬가지)
2. int[] 초기화는 int[] answer = {};
3. char 초기화는 '\0'
4. String 메소드 .charAt() 으로 String에서 인덱싱 가능
5. ArrayList 메소드 .contains() 로 리스트 안에 있는 항목 중복확인 가능
6. int[]{} 로 바로 사용하려면 new 붙이자
*/

import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> num_map = new HashMap<Integer, Integer>();

        for(int i=0; i<tangerine.length; i++){
            int cnt = num_map.getOrDefault(tangerine[i], 0);
            num_map.put(tangerine[i], cnt+1);
        }

        int answer = 0;
        ArrayList<Integer> cnt_array = new ArrayList<>(num_map.values());
        Collections.sort(cnt_array, Collections.reverseOrder());
        int limit = k;
        int num = 0;
        while(limit > 0){
            limit = limit - cnt_array.get(num);
            num++;
        }

        return num;
    }
}

/*
9월 9일 공부노트 2
1. 그냥 import java.util.*; 하자
2. hashMap 메소드 .getOrDefault(키, 기본값) map에 키가 존재하면 값을, 아니면 기본값을 반환
3. hashMap 메소드 .put(키, 값)
4. hashMap 메소드 .values()
5. arrayList 인덱스로 값 가져오려면 .get() 사용해야함
6. 정렬 메소드는 Collection.sort(list(, 내림차순은 Collections.reverseOrder()))
*/
