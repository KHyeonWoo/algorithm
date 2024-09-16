import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int idx=0; idx<commands.length; idx++){
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];
            ArrayList<Integer> sortedList = new ArrayList<>();
            for(int arrayIdx = i-1; arrayIdx<j; arrayIdx++){
                sortedList.add(array[arrayIdx]);
            }
            Collections.sort(sortedList);
            answer.add(sortedList.get(k-1));
        }
        int[] returnArr = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            returnArr[i] = answer.get(i);
        }

        return returnArr;
    }
}

//아래것도 같은 코드
import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}

/*
1. Arrays.sort(); 요거로 정렬
2. list에 추가하고 바꿀필요 없이 Arrays.copyOfRange(array, start, end); 하면 범위 카피가되네 ...
3. 
*/

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strNumbers = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            strNumbers[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strNumbers, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));

        if(strNumbers[0].equals("0")){
            return "0";
        }

        String max = strNumbers[0];
        //Integer.parseInt : string->int
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<strNumbers.length; i++){
            sb.append(strNumbers[i]);
        }

        return sb.toString();
    }
}

//람다식 정렬 잘 활용하자!!
//Integer.parseInt(), Integer.toString() 으로 형변환
