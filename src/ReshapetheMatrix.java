//https://leetcode.com/problems/reshape-the-matrix
import java.util.*;

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] answer = new int[r][c];
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                queue.offer(mat[i][j]);
            }
        }

        if(r*c != queue.size()) {
            return mat; 
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                answer[i][j] = queue.poll();
            }
        }

        return answer;
    }
}
