import java.io.*;
import java.util.StringTokenizer;

public class n과m1 {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];

        combination(0);
    }

    static void combination(int r) {
        if(M == r) {
            for(int i : arr) System.out.print(i + " ");
            System.out.println();
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            arr[r] = i+1;
            visited[i] = true;
            combination(r+1);
            visited[i] = false;
        }
    }
}
