//https://school.programmers.co.kr/learn/courses/30/lessons/42578
import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public int solution(String[][] clothes) {
        int answer = 1;
        
        for(int i = 0; i < clothes.length; i++) {
            int count = map.getOrDefault(clothes[i][1], 0);
            map.put(clothes[i][1], count + 1);
        }
        
        for(String key : map.keySet()) {
            int count = map.get(key);
            answer *= count + 1;
        }
        
        return answer - 1;
    }
}
