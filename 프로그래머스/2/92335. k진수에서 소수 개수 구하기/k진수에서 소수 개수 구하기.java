import java.util.*;
class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            sb.insert(0, n%k);
            n = n/k;
        }
        int cnt = 0;
        
        for(String str : sb.toString().split("0")){
            if(!str.isEmpty() && sosu(Long.parseLong(str))){
                cnt++;
            }
        }
        return cnt;
    }
        
//         Stack<Integer> st = new Stack<>();
        
//         while(n > 0){
//             st.push(n%k);
//             n = n/k;
//         }
//         int cnt = 0;
//         long num = 0;
//         while(!st.isEmpty()){
//             int current = st.pop();
//             if(current != 0){
//                 num = num * 10 + current;
//             } else {
//                 if(sosu(num)){
//                     cnt++;
//                 }
//                 num = 0;
//             }
//         }
        
//         if(sosu(num)){
//             cnt++;
//         }
        
//         return cnt;
//     }
    
    private boolean sosu(long n){
        if (n < 2) return false;
        if (n == 2) return true; // 2는 소수
        if (n % 2 == 0) return false; // 짝수는 소수 아님

        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}