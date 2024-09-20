class Solution {
    public int[] solution(int brown, int yellow) {
        for(int height=3; height<=brown/2; height++){
            int width = brown / 2 - height + 2;
            if(width * height == brown+yellow){
                return new int[] {width, height};
            }
        }
        int[] answer = {};
        return answer;
    }
}