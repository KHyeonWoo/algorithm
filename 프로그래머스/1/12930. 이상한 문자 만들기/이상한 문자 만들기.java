class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        // String[] strs = s.split(" ");
        // for(int j=0; j<strs.length; j++){
        //     for(int i=0; i<strs[j].length(); i++){
        //         if(i%2 == 0){
        //             sb.append(Character.toUpperCase(strs[j].charAt(i)));
        //         } else {
        //             sb.append(Character.toLowerCase(strs[j].charAt(i)));
        //         }
        //     }
        //     if(j != strs.length -1){
        //         sb.append(" ");
        //     }
        // }
        int idx = 0;
        for(char c: s.toCharArray()){
            if(idx % 2 == 0){
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
            idx ++;
            
            if(c == ' '){
                idx = 0;
            }
        }
        
        return sb.toString();
    }
}