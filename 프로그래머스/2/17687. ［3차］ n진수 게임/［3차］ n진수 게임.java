class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<t*m; i++){
            sb.append(convertToBase(i, n));
        }
        
        String str = sb.toString();
        String answer = "";
        for(int i=0; i<t*m; i=i+m){
            answer += str.charAt(i+p-1);
        }
        
        return answer;
    }
    
        // 숫자를 n진수로 변환해주는 함수
    private String convertToBase(int number, int base) {
        return Integer.toString(number, base).toUpperCase();
    }
}