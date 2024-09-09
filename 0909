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
9월 9일 공부노트
1. //ArrayList 쓸거면 import 해야함 (hashset 등등 마찬가지)
2. int[] 초기화는 int[] answer = {};
3. char 초기화는 '\0'
4. .charAt() 으로 String에서 인덱싱 가능
5. .contains() 로 리스트 안에 있는 항목 중복확인 가능
6. int[]{} 로 바로 사용하려면 new 붙이자
*/
