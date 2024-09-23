import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        
        String[] strs = s.split("},");
        int maxSize = 0;
        int idx = 0;
        for(String str: strs){
            String numStr = str.replace("{","").replace("}","");
            answer.add(new ArrayList<>());
            for(String num : numStr.split(",")){
                answer.get(idx).add(Integer.parseInt(num));
            }
            idx++;
        }
        
        Collections.sort(answer,(o1,o2) -> Integer.compare(o1.size(), o2.size()));
        int[] tuple = new int[answer.size()];
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        for(int i=0; i<answer.size(); i++){
            for(int j: answer.get(i)){
                lhs.add(j);
            }
        }
        Iterator<Integer> it = lhs.iterator();
        int i=0;
        while(it.hasNext()){
            tuple[i] = it.next();
            i++;
        }
        
        return tuple;
    }
}