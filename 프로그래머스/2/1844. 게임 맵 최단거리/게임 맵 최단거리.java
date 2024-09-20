import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        boolean[][] visited = new boolean[n][m];
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(0,0,1));
        visited[0][0] = true;
        
        while(!que.isEmpty()){
            Point current = que.poll();
            
            if(current.x == n-1 && current.y == m-1){
                return current.cnt;
            }
            
            for(int i=0; i<4; i++){
                int newx = current.x + dx[i];
                int newy = current.y + dy[i];
                
                if(newx >= 0 && newx < n && newy >= 0 && newy < m && !visited[newx][newy] && maps[newx][newy] == 1){
                    visited[newx][newy] = true;
                    que.offer(new Point(newx, newy, current.cnt+1));
                }
            }
        }
        return -1;
    }
    
    class Point{
        int x, y, cnt;
        
        Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}