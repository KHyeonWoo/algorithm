import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedHashSet<String> cacheSet = new LinkedHashSet<>();
        int time = 0;
        
        for(String city: cities){
            city = city.toLowerCase();
            if(cacheSet.contains(city)){
                time += 1;
                cacheSet.remove(city);
                cacheSet.add(city);
            } else {
                time += 5;
                cacheSet.add(city);
                
                if(cacheSet.size() > cacheSize){
                    Iterator it = cacheSet.iterator();
                    it.next();
                    it.remove();
                }
            }
        }
        
        return time;
    }
}