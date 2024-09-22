import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5; // 캐시 크기가 0일 경우 모두 캐시 미스
        }

        // LinkedHashSet을 사용하여 LRU 캐시 구현
        LinkedHashSet<String> cache = new LinkedHashSet<>(cacheSize);
        int totalTime = 0;

        for (String city : cities) {
            city = city.toLowerCase(); // 대소문자 구분하지 않기 위해 소문자로 변환
            
            if (cache.contains(city)) {
                // Cache hit
                totalTime += 1;
                // LRU 구현을 위해 기존 항목 제거 후 다시 추가하여 최신화
                cache.remove(city);
                cache.add(city);
            } else {
                // Cache miss
                totalTime += 5;
                if (cache.size() == cacheSize) {
                    // 캐시가 가득 차면 가장 오래된 항목 제거
                    Iterator<String> it = cache.iterator();
                    it.next();
                    it.remove();
                }
                cache.add(city);
            }
        }
        
        return totalTime;
    }
}