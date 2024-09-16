import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> que = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            que.offer(new int[]{i, priorities[i]});
        }
        int loc = 0;
        while(!que.isEmpty()){
            int[] current = que.poll();
            boolean isMax = true;
            for(int j=0; j<priorities.length; j++){
                if(current[1] < priorities[j]){
                    isMax = false;
                }
            }

            if(isMax){
                loc++;
                priorities[current[0]] = 0;
                if(current[0] == location){
                    return loc;
                }
            } else{
                que.offer(current);
            }

        }

        return answer;
    }
}
