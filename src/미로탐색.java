import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/2178
public class 미로탐색 {
    public static int N;
    public static int M;
    public static int[][] map;
    public static int[][] visited;
    public static int[] X = {1, -1, 0, 0};//동서남북
    public static int[] Y = {0, 0, -1, 1};
    public static int rsl = Integer.MAX_VALUE;
    public static Queue<Xy> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            String[] str = br.readLine().split("");
            for (int j = 1; j < M + 1; j++) {
                int tmp = Integer.parseInt(str[j - 1]);
                map[i][j] = tmp;
                visited[i][j] = 0;
            }
        }

        bfs(1,1);
        System.out.println(rsl);

    }
    public static void bfs(int n, int m){
        queue.offer(new Xy(n, m));
        visited[n][m] = 1;

        while(!queue.isEmpty()){
            Xy tmp = queue.poll();

            for(int i = 0; i < 4; i++){
                int tmpX = X[i] + tmp.x;
                int tmpY = Y[i] + tmp.y;

                if(tmpX >= 1 && tmpX < N+1 && tmpY >= 1 && tmpY < M+1){
                    if(map[tmpX][tmpY] == 1 && visited[tmpX][tmpY] == 0){
                        visited[tmpX][tmpY] = visited[tmp.x][tmp.y] + 1;

                        if(tmpX == N && tmpY == M){
                            rsl = Integer.min(rsl, visited[tmpX][tmpY]);
                        }
                        queue.offer(new Xy(tmpX, tmpY));;
                    }
                }
            }

        }

    }
    private static class Xy {
        private int x;
        private int y;

        public Xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
