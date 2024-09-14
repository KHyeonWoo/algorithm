import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> days = new LinkedList<>();
        for(int idx=0; idx<progresses.length; idx++){
            int day = (100-progresses[idx]) / speeds[idx];
            if((100-progresses[idx]) % speeds[idx] == 0){
                days.offer(day);
            } else {
                days.offer(day+1);
            }
        }
        List<Integer> result = new ArrayList<>();
        int day = days.poll();
        int cnt = 1;
        while(!days.isEmpty()){
            int currentDay = days.poll();
            if(day >= currentDay){
                cnt++;
            } else {
                result.add(cnt);
                day = currentDay;
                cnt=1;
            }
        }
        result.add(cnt);

        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}


/*
1. Queue<Integer> que = new LinkedList<>();
2. .poll() .offer()
3. ArrayList는 인덱스로 접근해야해서 메모리 차지를 많이할수 있으니 앞에서부터 꺼낼거면 Queue 쓰자
*/
