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

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        if(!Arrays.asList(words).contains(target)){
            return 0;
        }
        
        Queue<int[]> que = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        for(int i=0; i<words.length; i++){
            if(canChanged(begin, words[i])){
                que.offer(new int[]{i, 1});
            }
        }
        
        while(!que.isEmpty()){
            int[] current = que.poll();
            int idx = current[0];
            int cnt = current[1];
            
            if(words[idx].equals(target)){
                return cnt;
            }
            
            for(int i=0; i<words.length; i++){
                if(!visited[i] && canChanged(words[i], words[idx])){
                    visited[i] = true;
                    que.offer(new int[]{i, cnt+1});
                }
            }
        }
        
        return 1;
    }
    
    private boolean canChanged(String str1, String str2){
        int diffCnt = 0;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                diffCnt++;
            } 
            
            if(diffCnt>1){
                return false;
            }
        }
        return diffCnt == 1;
    }
}

//최단거리라서 BFS로 풀어야겠다 생각은 했는데 적용이 쉽지않네
//BFS는 Queue, visited 활용해서 단계별로 전부 찾아보는 느낌
