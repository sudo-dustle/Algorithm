import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/1697
public class 숨바꼭질 {
    public static int N;
    public static int K;
    public static boolean[] visited;
    public static Queue<Xy> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        Arrays.fill(visited, false);
        System.out.println(bfs(N));
    }

    private static int bfs(int n) {
        queue.offer(new Xy(n,0));
        visited[n] = true;

        while(!queue.isEmpty()){
            Xy tmp = queue.poll();

            if(tmp.x == K) return tmp.cnt;

            for (int i = 0; i < 3; i++) {
                int tmpX;

                if(i == 0) {
                    tmpX = tmp.x * 2;
                } else if(i == 1) {
                    tmpX = tmp.x + 1;
                } else {
                    tmpX = tmp.x - 1;
                }

                if (tmpX >= 0 && tmpX < visited.length && !visited[tmpX]) {
                    queue.offer(new Xy(tmpX, tmp.cnt + 1));
                    visited[tmpX] = true;
                }
            }
        }
        return -5;
    }
    private static class Xy {
        private int x;
        private int cnt;

        public Xy(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}
