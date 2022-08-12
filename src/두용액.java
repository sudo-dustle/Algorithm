import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int target = 0;
        int right = N-1;
        int left = 0;
        int sum = 0;
        int rslt = Integer.MAX_VALUE;
        int[] rsl = new int[2];

        while (left < right) {
            sum = arr[right] + arr[left];
            int tmp = Math.abs(sum);
            if (tmp < rslt) {
                rslt = tmp;
                rsl[0] = arr[left];
                rsl[1] = arr[right];
            }

            if (sum > target) right--;
            else left++;
        }

        System.out.println(rsl[0] + " " + rsl[1]);

    }


}
