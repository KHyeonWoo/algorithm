class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row1 = arr1.length;
        int col1 = arr1[0].length;
        int col2 = arr2[0].length;
        
        // 결과 행렬 초기화 (arr1의 행 수, arr2의 열 수)
        int[][] result = new int[row1][col2];

        // 행렬 곱셈 수행
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return result;
    }
}

/*
1. 이런 문제는 수학 지식이 있어야할듯..!
*/
