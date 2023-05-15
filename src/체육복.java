import java.util.*;
// https://school.programmers.co.kr/learn/courses/30/lessons/42862#
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] students = new int[n + 2];
        
        for(int i = 0; i < lost.length; i++) {
            students[lost[i]] -= 1;
        }
        
        for(int i = 0; i < reserve.length; i++) {
            students[reserve[i]] += 1;
        }

        for(int i = 1; i <= n; i++) {
            int tmp = students[i];
            
            if(tmp >= 0) {
                answer += 1;
            }
            else if(tmp == -1) {
                for(int j = -1; j <= 1; j++) {                    
                    if(students[i + j] == 1) {
                        students[i + j] -= 1;
                        answer += 1;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}
