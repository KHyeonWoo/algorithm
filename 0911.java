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

import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        // int[] arr = new int[n*n];
        // for(int col=0; col<n; col++){
        //     for(int row =0; row<n; row++){
        //         int maxNum = 0;
        //         if(col>=row){
        //             maxNum = col;
        //         } else{
        //             maxNum = row;
        //         }
        //         int idx = col * n + row;
        //         arr[idx] = maxNum+1;
        //     }
        // }
        int count = (int) (right - left) + 1;
        int[] answer = new int[count];
        for(int i=0; i<count; i++){
            long idx = i + left;
            int row = (int)(idx % n)+1;
            int col = (int)(idx / n)+1;
            answer[i] = Math.max(row, col);
        }
        return answer;
    }
}

/*
1. Math.max() !!
2. 행,열 번호 몫과 나머지로 구하는 방법 좋은데~?
*/
