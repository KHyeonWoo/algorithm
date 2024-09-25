import java.util.*;
class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<26; i++){
            dictionary.put(Character.toString('A'+i), i+1);
        }
        int idx = 27;
        int nextIdx = 1;
        String w = "";
        for(int i=0; i<msg.length(); i++){
            String c = Character.toString(msg.charAt(i));
            if(dictionary.containsKey(w+c)){
                w += c;
            } else {
                dictionary.put(w+c, idx++);
                answer.add(dictionary.get(w));
                w = c;
            }
        }
        
        if(!w.isEmpty()){
            answer.add(dictionary.get(w));
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}