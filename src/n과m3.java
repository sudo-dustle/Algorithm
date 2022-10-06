import java.io.*;
import java.util.StringTokenizer;

public class n과m3 {
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

        combination(0);
        bw.flush();
    }

    static void combination(int r) throws IOException {
        if(M == r) {
            for(int i : arr) bw.write(i + " ");
            bw.write("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            arr[r] = i+1;
            combination(r+1);
        }
    }
}
