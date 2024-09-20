class Solution {
    public int solution(int n) {
        int nextNum = n+1;
        int nOneCnt = binaryCnt(n);
        while(nOneCnt != binaryCnt(nextNum)){
            nextNum++;
        }
        return nextNum;
    }
    
    private int binaryCnt(int n){
//         StringBuilder sb = new StringBuilder();
//         while(n > 0){
//             sb.insert(0, n%2);
//             n /= 2;
//         }
        
//         int cnt = 0;
//         for(String s: sb.toString().split("")){
//             if(s.equals("1")){
//                 cnt++;
//             }
//         }
        int cnt=0;
        while(n>0){
            if(n % 2 == 1) 
                cnt++;
            
            n /= 2;
        }
        return cnt;
    }
}