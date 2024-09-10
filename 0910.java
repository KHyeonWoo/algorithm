import java.util.*;

class Solution {
    public int solution(int[] elements) {

        HashSet<Integer> ele_set = new HashSet<Integer>();
        int len = elements.length;
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
            int add_num = 0;
                for(int k=i; k<=i+j; k++){
                    int idx = k%len;
                    add_num += elements[idx];
                }
                ele_set.add(add_num);
            }
        }
        int answer = ele_set.size();
        return answer;
    }
}

/* 
1. HashSet은 .add 메소드로 추가
2. .size()로 크기 확인 가능
*/


import java.util.Stack;

class Solution {
    public int solution(String s) {
        int length = s.length();
        int validCount = 0;
        
        // 문자열을 두 번 붙여서 회전된 문자열을 쉽게 추출할 수 있도록 함
        String doubled = s + s;
        
        // 모든 회전된 문자열을 검사
        for (int i = 0; i < length; i++) {
            String rotated = doubled.substring(i, i + length);
            if (isValidParentheses(rotated)) {
                validCount++;
            }
        }
        
        return validCount;
    }
    
    private boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false; // 스택이 비어있는데 닫는 괄호가 등장함
                }
                char open = stack.pop();
                if (!isValidPair(open, ch)) {
                    return false; // 올바른 쌍이 아님
                }
            }
        }
        
        return stack.isEmpty(); // 스택이 비어있다면 올바른 괄호 문자열
    }
    
    private boolean isValidPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}

/*
1. 함수화 하는거 습관화하기
2. Stack .push() .pop() .peek() .empty() 활용
*/
