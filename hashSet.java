import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public int solution(String numbers) {
        Set<Integer> primeSet = new HashSet<>();
        int length = numbers.length();
        
        // Generate all possible permutations of all lengths
        for (int len = 1; len <= length; len++) {
            generatePermutations(numbers, len, primeSet);
        }

        return primeSet.size();
    }

    private void generatePermutations(String numbers, int length, Set<Integer> primeSet) {
        ArrayList<String> permutations = new ArrayList<>();
        permutations.add(""); // Start with empty string
        
        // Build permutations of the given length
        for (int len = 0; len < length; len++) {
            ArrayList<String> newPermutations = new ArrayList<>();
            for (String perm : permutations) {
                for (int i = 0; i < numbers.length(); i++) {
                    if (perm.indexOf(numbers.charAt(i)) == -1) { // Ensure no duplicate digits
                        newPermutations.add(perm + numbers.charAt(i));
                    }
                }
            }
            permutations = newPermutations;
        }

        // Process each permutation and add it to the set if it's a prime number
        for (String perm : permutations) {
            if (!perm.isEmpty()) {
                try {
                    int num = Integer.parseInt(perm);
                    if (isPrime(num)) {
                        primeSet.add(num);
                    }
                } catch (NumberFormatException e) {
                    // Ignore invalid numbers
                }
            }
        }
    }

    // Check if a number is a prime number
    private boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("17")); // Output: 3
        System.out.println(sol.solution("011")); // Output: 2
    }
}
