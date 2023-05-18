//https://leetcode.com/problems/rank-transform-of-an-array/
import java.util.*;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int[] arrayRankTransform(int[] arr) {

        int[] copy = arr.clone(); 
        Arrays.sort(copy);

        int rank = 1;
        for(int i = 0; i < copy.length; i++) {
            if(!map.containsKey(copy[i])) {
                map.put(copy[i], rank++);
            }
        }

        int[] answer = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            answer[i] = map.get(arr[i]);
        }

        return answer;
    }
}
