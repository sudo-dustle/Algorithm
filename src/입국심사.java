import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 입국심사 {
    public static int N;
    public static long M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long start = 0;
        long end = M * 1000000000;
        long mid;

        while (start < end) {
            mid = (start + end) / 2;

            if (determine(mid, arr)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        System.out.println(start);
    }

    private static boolean determine(long mid, int[] arr) {
        long sum = 0;

        for (int time : arr) {
            sum += mid / time;

            if(sum > M) break;
        }

        return sum < M;
    }
}
