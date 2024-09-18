class Solution {
    public int solution(String word) {
        int[] values = {781,156,31,6,1};
        String strIndex = "AEIOU";
        int answer = 0;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            System.out.println(answer);
            for(int j=0; j<5; j++){
                if(ch == strIndex.charAt(j)){
                    answer += j * values[i] + 1;
                }
            }
        }

        return answer;
    }
}


/*
1. 가중치를 계산해서 내 단어 앞에 몇개가 있을지 계산하는 방법..
*/
