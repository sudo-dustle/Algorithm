import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_재귀 {
    public static int N;
    public static int answer = Integer.MIN_VALUE;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0);

        System.out.println(answer);

    }

    private static void solve(int current, int rsl) {
        if(current == N){
            answer =  Math.max(rsl, answer);
            return;
        }
        if(current > N) return;

        int day = arr[current][0];
        int money = arr[current][1];

        //일 한 경우
        solve(current+day, rsl + money);
        //일 안한 경우
        solve(current+1, rsl);
    }
}
