// 내가 짠 코드 ...
import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int min = n;
        for(int i=0; i<wires.length; i++){
            int cntDif = connectNode(wires, i);
            if(min > cntDif){
                min = cntDif;
            }
        }
        return min;
    }
    
    private int connectNode(int[][] wires, int removeIdx){
        Set<Integer> connectNodes1 = new HashSet<>();
        Set<Integer> connectNodes2 = new HashSet<>();
        for(int i=0; i<wires.length; i++){
            if(i!=removeIdx){
                if(i==0 || (removeIdx == 0 && i==1)){
                    connectNodes1.add(wires[i][0]);
                    connectNodes1.add(wires[i][1]);
                } else if(connectNodes1.contains(wires[i][0])){
                    connectNodes1.add(wires[i][1]);
                } else if(connectNodes1.contains(wires[i][1])){
                    connectNodes1.add(wires[i][0]);
                } 
                else {
                    connectNodes2.add(wires[i][0]);
                    connectNodes2.add(wires[i][1]);
                }
            }
        }
        if(connectNodes1.size() > connectNodes2.size()){
            return connectNodes1.size() - connectNodes2.size();
        } else {
            return connectNodes2.size() - connectNodes1.size();
        }
    }
}


//GPT 코드
import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        // 인접 리스트로 그래프를 표현
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프에 간선 추가
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        int minDifference = n;  // 최소 차이

        // 각 간선을 하나씩 제거하고 계산
        for (int[] wire : wires) {
            int node1 = wire[0];
            int node2 = wire[1];

            // 간선을 제거
            graph.get(node1).remove((Integer) node2);
            graph.get(node2).remove((Integer) node1);

            // BFS로 두 네트워크의 크기를 계산
            int size1 = bfs(graph, node1, n);
            int size2 = n - size1;

            // 크기 차이의 최소값 갱신
            minDifference = Math.min(minDifference, Math.abs(size1 - size2));

            // 간선 복원
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        return minDifference;
    }

    // BFS로 노드의 연결된 크기를 구하는 함수
    private int bfs(List<List<Integer>> graph, int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return count;
    }
}


//참고해서 혼자 짜본 코드인데.. 어렵네

import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        //그래프를 List<List<Integer>> 로 구현
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int[] wire: wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        int minDif = n;
        
        for(int[] wire: wires){
            int node1 = wire[0];
            int node2 = wire[1];
            
            //index를 제거하는게 아닌 node2 자체를 제거하는거라 Object형으로 변환해서 제거
            graph.get(node1).remove((Integer) node2);
            graph.get(node2).remove((Integer) node1);
            
            int nodes1Cnt = bfs(graph, node1);
            int nodes2Cnt = n - nodes1Cnt;
            
            minDif = Math.min(minDif, Math.abs(nodes1Cnt - nodes2Cnt));
            
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        
        return minDif;
    }
    
    private int bfs(List<List<Integer>> graph, int start){
        boolean[] visited = new boolean[graph.size()+1];
        Queue<Integer> que = new LinkedList<>();
        int cnt = 0;
        
        visited[start] = true;
        que.offer(start);
        
        while(!que.isEmpty()){
            int currentNum = que.poll();
            visited[currentNum] = true;
            cnt++;
            for(int node: graph.get(currentNum)){
                if(!visited[node]){
                    que.offer(node);
                }
            }
        }
        return cnt;
    }
    
}
