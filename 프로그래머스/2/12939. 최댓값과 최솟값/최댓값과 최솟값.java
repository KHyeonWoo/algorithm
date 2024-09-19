class Solution {
    public String solution(String s) {
        String[] sList = s.split(" ");
        int min=Integer.parseInt(sList[0]), max = Integer.parseInt(sList[0]);
        for(String str: sList){
            min = Math.min(min, Integer.parseInt(str));
            max = Math.max(max, Integer.parseInt(str));
        }
        String answer = min + " " + max;
        return answer;
    }
}