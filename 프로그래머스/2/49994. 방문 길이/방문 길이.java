import java.util.*;


class Solution {
    public int solution(String dirs) {
        Set<String> moveSet = new HashSet<>();
        int[] position = {0,0};
        for(String move: dirs.split("")){
            int[] current = {position[0], position[1]};
            if(move.equals("U") && current[1] < 5){
                current[1] += 1;
            } else if(move.equals("D") && current[1] > -5){
                current[1] -= 1;
            } else if(move.equals("L") && current[0] > -5){
                current[0] -= 1;
            } else if(move.equals("R") && current[0] < 5){
                current[0] += 1;
            }
            String str = "";
            if(position[0] != current[0] || position[1] != current[1]){
                if(position[0] > current[0] || position[1] > current[1]){
                    str = Integer.toString(position[0]) +Integer.toString(position[1]) + Integer.toString(current[0]) + Integer.toString(current[1]);
                } else {
                    str = Integer.toString(current[0]) +Integer.toString(current[1]) + Integer.toString(position[0]) + Integer.toString(position[1]);
                }

                moveSet.add(str);
                position[0] = current[0];
                position[1] = current[1];
            }
        }
        return moveSet.size();
    }
}