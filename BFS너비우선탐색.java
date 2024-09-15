import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {0,0});

        while(!que.isEmpty()){
            int[] current = que.poll();
            int x = current[0];
            int y = current[1];
            
            if(x == n-1 && y == m-1){
                return maps[x][y];
            }
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1){
                    que.offer(new int[] {nx,ny});
                    maps[nx][ny] = maps[x][y] + 1;
                }
            }
        }
        return -1;
    }
}


/*
1. 최단거리는 무조건 BFS
2. BFS는 Queue, DFS는 재귀함수(스택으로 구현 가능한데 재귀로 할 수 있으면 굳)
3. 아직 어렵다;;; 더 풀어보자
*/
