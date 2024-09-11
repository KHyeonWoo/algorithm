import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int length = discount.length;
        HashMap<String, Integer> wantMap = new HashMap<>();
        for(int wantIdx=0; wantIdx<want.length;wantIdx++){
            wantMap.put(want[wantIdx], number[wantIdx]);
        }
        for(int i=0 ; i<=length-10; i++){
            HashMap<String, Integer> tenDays = new HashMap<>();
            for(int j=i; j<i+10; j++){
                int cnt = tenDays.getOrDefault(discount[j],0);
                tenDays.put(discount[j],cnt+1);
            }
            if(wantMap.equals(tenDays)){
                answer++;
            }
        }
        return answer;
    }
}

/*
1. hashMap 끼리는 .equals 로 비교가 가능함 (비교 대상이 크기가 더 크면(다 포함하고 있으면) True로 나오니 조심)
*/
