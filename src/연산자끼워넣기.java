import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {
    static int N;
    static int[] math;
    static int[] num;
    static int init;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        init += Integer.parseInt(st.nextToken());
        num = new int[N-1];
        for(int i = 0; i < N-1; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        math = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            math[i] = Integer.parseInt(st.nextToken());
        }

        recursive(0, 0, init);
        System.out.println(max);
        System.out.println(min);
    }

    public static void recursive(int r, int idx, int tmp) {
        if(r == N-1) {
            max = Math.max(tmp, max);
            min = Math.min(tmp, min);
            return;
        }

        if(math[0] > 0) {
            int t = tmp + num[idx];
            math[0]--;
            recursive(r+1, idx+1, t);
            math[0]++;
        }

        if(math[1] > 0) {
            int t = tmp - num[idx];
            math[1]--;
            recursive(r+1, idx+1, t);
            math[1]++;
        }

        if(math[2] > 0) {
            int t = tmp * num[idx];
            math[2]--;
            recursive(r+1, idx+1, t);
            math[2]++;
        }

        if(math[3] > 0) {
            int t = tmp / num[idx];
            math[3]--;
            recursive(r+1, idx+1, t);
            math[3]++;
        }
    }
}
