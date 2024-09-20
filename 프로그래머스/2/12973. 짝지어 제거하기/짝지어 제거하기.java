import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<String> stack = new Stack<>();
        
        for(String str : s.split("")){
            if(!stack.isEmpty() && str.equals(stack.peek())){
                stack.pop();
            } else {
                stack.push(str);
            }
        }

        if(stack.isEmpty()){
            return 1;
        } else {
            return 0;
        }
    }
}