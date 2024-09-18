//PriorityQueue 는 정렬된 Queue라고 생각하면 될듯
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 내림차순

        for(int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }
        int cnt=0;
        while(!pq.isEmpty() && pq.peek() < K){
            pq.offer(pq.poll() + (pq.poll()*2));
            cnt++;

            if(pq.size() < 2 && pq.peek() < K){
                return -1;
            }
        }
        return cnt;
    }
}
