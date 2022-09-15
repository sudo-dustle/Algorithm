import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/1260
public class DFS와BFS {
    public static boolean[] visited = new boolean[1001];
    public static int[][] map = new int[1001][1001];
    public static int N;
    public static int M;
    public static int V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            map[first][second] = 1;
            map[second][first] = 1;
        }

        dfs(V);
        System.out.println();
        bfs(V);
    }

    private static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for(int i = 1; i <= N; i++){
            if(map[v][i] == 1 && visited[i] == false) dfs(i);
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = false;

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            System.out.print(tmp + " ");
            for(int i = 1; i <= N; i++){
                if(map[tmp][i] == 1 && visited[i] == true){
                    queue.offer(i);
                    visited[i] = false;
                }
            }
        }
    }
}