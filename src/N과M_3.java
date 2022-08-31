import java.io.*;
import java.util.StringTokenizer;

public class N과M_3 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];

        combination(arr,0, N, M);
        bw.flush();
    }

    public static void combination(int[] arr, int start, int n, int m) throws IOException {
        if (m == start) {
            for (int i : arr) {
                bw.write(i+ " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[start] = i + 1;
            combination(arr,start + 1, n, m);
        }
    }
}
