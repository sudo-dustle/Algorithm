import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_7 {
    static int N;
    static int M;
    static int[] arr;
    static int[] answer;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        arr = new int[N];
        answer = new int[M];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        recursive(0);
        bw.flush();
    }

    static void recursive(int r) throws IOException {
        if(r == M) {
            for(int i : answer) bw.write(i + " ");
            bw.write("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            answer[r] = arr[i];
            recursive(r + 1);
        }
    }
}
