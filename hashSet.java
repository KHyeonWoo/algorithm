import java.util.HashSet;
import java.util.Set;

public class Solution {
    // 소수 판별 함수
    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 가능한 모든 숫자 조합을 생성하는 함수
    public void generateCombinations(String prefix, String numbers, Set<Integer> primes) {
        if (!prefix.isEmpty()) {
            int num = Integer.parseInt(prefix);
            if (isPrime(num)) {
                primes.add(num); // 중복된 소수를 막기 위해 Set을 사용
            }
        }

        //나는 배열로 visited를 만들어서 중복을 막았는데
        //그냥 substring으로 하나씩 빼고 새로운 String을 만드니까 훨씬 간결하네 ;;
        for (int i = 0; i < numbers.length(); i++) {
            generateCombinations(prefix + numbers.charAt(i),
                                 numbers.substring(0, i) + numbers.substring(i + 1),
                                 primes);
        }
    }

    public int solution(String numbers) {
        Set<Integer> primes = new HashSet<>(); // 중복을 제거하고 소수를 저장할 Set
        generateCombinations("", numbers, primes);
        return primes.size();
    }
}
