import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];
        
        for(int i=0; i<n; i++){
            student[i] = 1;
        }
        
        for(int l=0; l<lost.length; l++){
            student[lost[l]-1] -= 1;
        }
        
        for(int r=0; r<reserve.length; r++){
            student[reserve[r]-1] += 1;
        }
        
        for(int i=0; i<n; i++){
            if(student[i] == 0){
                if(i != 0 && student[i-1] == 2){
                    student[i] = 1;
                    student[i-1] = 1;
                } else if (i != n-1 && student[i+1] ==2){
                    student[i] = 1;
                    student[i+1] = 1;
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(student[i] > 0){
                cnt++;
            }
        }
        return cnt;
    }
}