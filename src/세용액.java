import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);


        long gap = Long.MAX_VALUE;
        long[] rsl = new long[3];
        int target = 0;
        long sum;
        long tmp;

        for(int i = 0; i < N; i++){
            int right = N-1;
            int left = i+1;
            long fixed = arr[i];
            while (left < right) {
                sum = arr[right] + arr[left] + fixed;
                tmp = Math.abs(sum);
                if (tmp < gap) {
                    gap = tmp;
                    rsl[0] = fixed;
                    rsl[1] = arr[left];
                    rsl[2] = arr[right];
                }

                if (sum > target) right--;
                else left++;
            }
        }

        System.out.println(rsl[0] + " " + rsl[1] + " " + rsl[2]);

    }
}
