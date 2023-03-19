import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기 {
    public static int N;
    public static int M;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        long start = 0;
        long end = Integer.MIN_VALUE;
        long mid = 0; //나무 길이

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(arr[i], end);
        }

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

    private static boolean determine(int[] arr, long height) { // 10 15 17 20 -> 15
        long sum = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] > height) {
                sum += arr[i] - height;
            }

            if (sum >= M) {
                return true;
            }
        }

        return false;
    }
}
