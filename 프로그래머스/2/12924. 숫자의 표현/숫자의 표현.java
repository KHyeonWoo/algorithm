class Solution {
    public int solution(int n) {
        int cnt = 0;
        for(int i=1; i<=n/2; i++){
            int total = i;
            int idx = 1;
            while(total < n){
                total += i + idx;
                idx++;
            }
             
            if(total == n){
                cnt++;
            }
        }
        return cnt+1;
    }
}