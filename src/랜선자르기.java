import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기 {
    public static int K;
    public static int N;
    public static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[K];
        long max = Integer.MIN_VALUE;

        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long start = 0;
        long end = max + 1;
        long mid = 0;

        while (start < end) {
            mid = (start + end) / 2;

            if (determine(arr, mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        System.out.println(start - 1);
    }

    private static boolean determine(long[] arr, long length) {
        long sum = 0;

        for (long LAN : arr) {
            sum += LAN / length;

            if (sum >= N) return true;
        }

        return false;
    }
}
