import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 볼링공고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = N * (N-1) / 2;

        Arrays.sort(arr);

        int cnt = 1;
        int tmp = arr[0];

        //1 2 2 3 3
        for(int i = 0; i < N; i++) {
            if(arr[i] == tmp) cnt++;
            else {
                if(cnt > 1) {
                    answer -= cnt*(cnt-1) / 2;
                }
                tmp = arr[i];
                cnt = 1;
            }
        }

        System.out.println(answer);
    }
}
