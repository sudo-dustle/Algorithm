import java.io.*;
import java.util.StringTokenizer;

public class n과m2 {
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        combination(0, 0);
    }

    static void combination(int r, int start) {
        if(M == r) {
            for(int i : arr) System.out.print(i + " ");
            System.out.println();
            return;
        }

        for(int i = start; i < N; i++) {
            arr[r] = i+1;
            combination(r+1, i+1);
        }
    }
}
