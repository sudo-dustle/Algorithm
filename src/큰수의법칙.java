import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
//11시 40분 ~ 12시 09분
public class 큰수의법칙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        int cnt = 0;
        int index = N - 1;

        for(int i = 0; i < M; i++) {
            if(cnt < K) {
                answer += arr[index];
                cnt += 1;
            }
            else {
                answer += arr[index - 1];
                cnt = 0;
            }
        }

        System.out.print(answer);

    }
}
