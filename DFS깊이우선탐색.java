import java.util.*;

class Solution {
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        goDungeon(dungeons, k, 0, visited);
        return max;
    }

    private void goDungeon(int[][] dungeons, int pirodo, int cnt, boolean[] visited){


        for(int i=0; i<dungeons.length; i++){
            if(pirodo - dungeons[i][0] >= 0 && !visited[i]){
                visited[i] = true;
                goDungeon(dungeons, pirodo - dungeons[i][1], cnt+1, visited);
                visited[i] = false;
            }
        }

        if(cnt > max){
            max = cnt;
        }

    }
}
/*
1. cnt++ 로 키우고 재귀함수를 타면 결과값에 잘못 반영됨 명심!!!
*/

import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int index, int sum){
        if(index == numbers.length){
            if(sum == target){
                return 1;
            } else{
                return 0;
            }
        } else {
            return dfs(numbers, target, index+1, sum + numbers[index]) + 
                dfs(numbers, target, index+1, sum - numbers[index]);
        }

    }
}

/*
0915 이제 그냥 공부하면서 오답노트처럼 적고 배운거를 제목으로 적어야겠다..!
1. DFS 는 거의 재귀인듯
*/

import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int netCnt = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(computers, visited, i);
                netCnt++;
            }
        }
        return netCnt;
    }

    private void dfs(int[][] computers, boolean[] visited, int idx){
        visited[idx] = true;

        for(int i=0; i<computers[idx].length; i++){
            if(computers[idx][i] == 1 && !visited[i]){
                dfs(computers, visited, i);
            }
        }
    }
}

//문제를 보고 DFS/BFS 판단하는 능력 길러야겠다..
//약간 모든 노드 "방문"은 DFS, "최단거리" BFS 인거같긴 함
