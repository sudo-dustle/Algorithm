import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N];
        int[] arr = new int[M];

        combination(arr, visited, 0, N, M);
    }
    public static void combination(int[] arr, boolean[] visited, int start, int n, int m){
        if(m == start) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[start] = i + 1;
                combination(arr, visited,start+1, n, m);
                visited[i] = false;
            }
        }
    }
}
