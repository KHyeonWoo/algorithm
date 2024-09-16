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




//트럭 다리 건너기 문제
import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridge_weight = 0;
        int idx = 0;
        Queue<Integer> que = new LinkedList<>();

        //다리 길이만큼 0 넣고
        for(int i=0; i<bridge_length; i++){
            que.offer(0);
        }
        //que를 다리라 생각하고 풀면 됨~~
        while(!que.isEmpty()){
            answer++;
            bridge_weight -= que.poll();
            if(idx < truck_weights.length){
                if(bridge_weight + truck_weights[idx] <= weight){
                    bridge_weight += truck_weights[idx];
                    que.offer(truck_weights[idx]);
                    idx++;
                } else{
                    que.offer(0);
                }
            }
        }

        return answer;
    }
}
