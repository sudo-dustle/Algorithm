public class 자릿수더하기 {
    public static void main(String[] args) {
        System.out.println(solution2(135));
        System.out.println(solution2(245));
        System.out.println(solution2(126));
        System.out.println(solution2(457));
        System.out.println(solution2(10));
        System.out.println(solution2(3));
    }

    public static int solution(int n) {
        int answer = 0;

        //135 5 135 % 10
        while (n > 0) {
            answer += n % 10;
            n = n / 10;
        }

        return answer;
    }

    public static int solution2(int n) {
        int answer = 0;

        String string = Integer.toString(n);
        char[] chars = string.toCharArray();

        for(char c : chars) {
            answer += c - '0';
        }

        return answer;
    }
}
