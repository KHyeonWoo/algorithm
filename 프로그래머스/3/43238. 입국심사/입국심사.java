import java.util.*;
class Solution {
    public long solution(int n, int[] times) {

        long left = 1;
        long right = (long) times[0];
        for(int i=0; i<times.length; i++){
            right = Math.min((long) times[i], right);
        }
        right = right * n;
        while(left < right){
            
            long mid = (left + right) / 2;
            long totalPeople = 0;
            for(int time : times){
                totalPeople += mid / time;
            }
            
            if(totalPeople < n){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
