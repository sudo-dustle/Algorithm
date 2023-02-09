import java.util.Arrays;

public class 두개이하로다른비트 {
    public static void main(String[] args) {
        long[] solution = solution(new long[]{2,7});
        System.out.println(Arrays.toString(solution));
    }
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            answer[i] = makeComb(number);
        }

        return answer;
    }

    public static Long makeComb(long number) {
        long answer = Long.MAX_VALUE;

        for(int i = 0; i < 64; i++) {
            for(int j = i; j < 64; j++) {
                long compareNum = (1L << i | 1L << j);
                long tmpNum = number ^ compareNum;
                if(number < tmpNum && answer > tmpNum) {
                    answer = tmpNum;
                }
            }
        }

        return answer;
    }
}
