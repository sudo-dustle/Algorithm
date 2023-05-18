//https://leetcode.com/problems/word-pattern
import java.util.*;

class Solution {
    Map<Character, String> map1 = new HashMap<>();
    Map<String, Character> map2 = new HashMap<>();
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");

        if(pattern.length() != strings.length) return false;
        
        for(int i = 0; i < pattern.length(); i++) {
            char tmpPattern = pattern.charAt(i);
            String tmpString = strings[i];

            String mapString = map1.getOrDefault(tmpPattern, "null");
            char mapChar = map2.getOrDefault(tmpString, '8');

            if(mapChar == '8' && mapString.equals("null")) {
                map1.put(tmpPattern, tmpString);
                map2.put(tmpString, tmpPattern);
            }

            if(mapChar != '8') {
                if(mapChar != tmpPattern) {
                    System.out.println("1 index : " + i);
                    return false;
                }
            }

            if(!mapString.equals("null")) {
                if(!mapString.equals(tmpString)) {
                    System.out.println("2 ndex : " + i);
                    return false;
                }
            }
        }

        return true;
    }
}
