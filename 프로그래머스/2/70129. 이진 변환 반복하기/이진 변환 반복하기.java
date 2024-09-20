class Solution {
    public int[] solution(String s) {
        int removeCnt = 0;
        int changeCnt = 0;
        while(!s.equals("1")){
            StringBuilder sb = new StringBuilder();
            for(String c: s.split("")){
                if(c.equals("0")){
                    removeCnt++;
                } else {
                    sb.append(c);
                }
            }
            s = change(sb.length());
            changeCnt++;
        }
        return new int[]{changeCnt, removeCnt};
    }
    
    private String change(int n){
        StringBuilder sb = new StringBuilder();
        
        while(n>0){
            sb.insert(0,n%2);
            n /= 2;
        }
        return sb.toString();
    }
}