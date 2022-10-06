import java.io.*;
import java.util.StringTokenizer;

public class N과M_4 {
    static int N;
    static int M;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        combination(0, 0);
        bw.flush();
    }

    static void combination(int r, int start) throws IOException {
        if(M == r) {
            for(int i : arr) bw.write(i + " ");
            bw.write("\n");
            return;
        }

        for(int i = start; i < N; i++) {
            arr[r] = i+1;
            combination(r+1, i);
        }
    }
}
