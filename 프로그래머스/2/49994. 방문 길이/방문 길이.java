import java.util.*;


class Solution {
    public int solution(String dirs) {
        Set<String> moveSet = new HashSet<>();
        int[] position = {0,0};
        for(char move: dirs.toCharArray()){
            int dx = position[0];
            int dy = position[1];
            if(move == 'U'){
                dx += 1;
            } else if(move == 'D'){
                dx -= 1;
            } else if(move == 'L'){
                dy -= 1;
            } else if(move == 'R'){
                dy += 1;
            }
            if(dy > 5 || dy < -5 || dx > 5 || dx < -5){
                continue;
            }
            
            String str1 = position[0] + "" + position[1] + "" + dx + "" + dy;

            String str2 = dx + "" + dy + "" + position[0] + "" + position[1];

            moveSet.add(str1);
            moveSet.add(str2);
            position[0] = dx;
            position[1] = dy;

        }
        return moveSet.size()/2;
    }
}