//https://leetcode.com/problems/first-bad-version
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long start = 1;
        long end = (long) n;
        long mid = 0;

        while(start < end) {
            mid = (start + end) / 2;
            System.out.println("mid : "  + mid + " start : " + start + " end : " + end);

            if(!isBadVersion((int)mid)) {
                start = mid + 1;
            }
            else {
                end = mid;
            }    
        }

        return (int)start;
    }
}
