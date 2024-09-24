import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String, Integer> str1Map = new HashMap<>();
        
        float str1Cnt = 0f;
        for(int i=0; i<str1.length()-1; i++){
            String str = str1.substring(i, i+2);
            if(str.charAt(0) >= 'a' && str.charAt(0) <= 'z' && str.charAt(1) >= 'a' && str.charAt(1) <= 'z'){
                str1Map.put(str, str1Map.getOrDefault(str, 0) + 1);
                str1Cnt++;
            }
        }
        float str2Cnt = 0f;
        float geouCnt = 0f;
        
        for(int i=0; i<str2.length()-1; i++){
            String str = str2.substring(i, i+2);
            if(str.charAt(0) >= 'a' && str.charAt(0) <= 'z' && str.charAt(1) >= 'a' && str.charAt(1) <= 'z'){
                str2Cnt++;
                if(str1Map.containsKey(str) && str1Map.get(str) > 0){
                    str1Map.put(str, str1Map.get(str) - 1);
                    geouCnt++;
                }
            }
        }
        float hapCnt = str1Cnt + str2Cnt - geouCnt;
        
        if(hapCnt == 0.0){
            return 65536;
        }
        double jaccardSimilarity = (double) geouCnt / hapCnt;
        return (int) (jaccardSimilarity * 65536);
    }
}