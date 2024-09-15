

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
