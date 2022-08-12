import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        //수익 저장
        int[] memorize = new int[N+1];

        for(int i = 0; i < N; i++){
            if(i + T[i] <= N){
                memorize[i + T[i]] = Math.max(memorize[i + T[i]], memorize[i] + P[i]);
            }
            memorize[i+1] = Math.max(memorize[i + 1], memorize[i]);
        }

        System.out.println(memorize[N]);

    }
}
