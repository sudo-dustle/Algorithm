import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 모험가길드 {
    //12시 11분 ~ 25분
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        //1 2 2 2 3
        int idx = 0;
        int answer = 0;

        while (idx < N) {
            int tmp = arr[idx];
            idx += tmp;

            if(idx > N || tmp < arr[idx - 1]) {
                idx = (idx - tmp) + 1;
                continue;
            }

            answer++;
        }

        System.out.println(answer);
    }
}
