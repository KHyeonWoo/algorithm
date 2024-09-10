import java.util.*;

class Solution {
    public int solution(int[] elements) {

        HashSet<Integer> ele_set = new HashSet<Integer>();
        int len = elements.length;
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
            int add_num = 0;
                for(int k=i; k<=i+j; k++){
                    int idx = k%len;
                    add_num += elements[idx];
                }
                ele_set.add(add_num);
            }
        }
        int answer = ele_set.size();
        return answer;
    }
}

/* 
1. HashSet은 .add 메소드로 추가
2. .size()로 크기 확인 가능
*/
