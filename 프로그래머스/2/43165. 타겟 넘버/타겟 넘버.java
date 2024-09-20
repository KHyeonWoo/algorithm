class Solution {
    public int solution(int[] numbers, int target) {
        
        return dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] numbers, int target, int idx, int cnt){
        if(idx == numbers.length ){
            if(cnt == target)
                return 1;
            else
                return 0;
        }
        return dfs(numbers, target, idx+1, cnt+numbers[idx]) + dfs(numbers, target, idx+1, cnt-numbers[idx]);
    }
}