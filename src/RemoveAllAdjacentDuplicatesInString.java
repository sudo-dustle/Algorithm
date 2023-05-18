//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string
import java.util.*;

class Solution {
    Stack<Character> stack = new Stack<>();
    public String removeDuplicates(String s) {

        for(int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == tmp) {
                stack.pop();
            }
            else {
                stack.push(tmp);
            }
        }

        String answer = "";

        for(char c: stack) {
            answer += c;
        }

        return answer;
    }
}
