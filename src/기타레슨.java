import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타레슨 {
    public static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        int start = max;
        int end = sum;
        int mid;

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

    private static boolean determine(int mid, int[] arr) {
        int count = 0;
        int prevSum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (prevSum + arr[i] <= mid) {
                prevSum += arr[i];
            }
            else {
                count += 1;
                i -= 1;
                prevSum = 0;
            }
        }

        if(prevSum > 0) {
            count += 1;
        }

        return count > M;
    }
}
