import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];

        combination(visited,0, N, M);
    }
    public static void combination(boolean[] visited, int start, int N, int M){
        if(M == 0){
            print(visited, N);
            return;
        }

        for(int i = start; i < N; i++){
            visited[i] = true;
            combination(visited, i + 1, N, M - 1);
            visited[i] = false;
        }
    }

    public static void print(boolean[] visited, int N) {
        for (int i = 0; i <= N; i++) {
            if (visited[i]) {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println();
    }
}
