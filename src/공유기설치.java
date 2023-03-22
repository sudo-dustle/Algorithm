import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {
    public static int N;
    public static int C;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 1;
        int end = arr[N - 1] - arr[0] + 1;
        int mid;

        while (start < end) {
            mid = (start + end) / 2;

            if (determine(mid, arr)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        System.out.println(start - 1);
    }

    private static boolean determine(int mid, int[] arr) {
        int count = 1;
        int last = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int distance = arr[i] - last;

            if (distance >= mid) {
                count++;
                last = arr[i];
            }
        }

        return count >= C;
    }
}
