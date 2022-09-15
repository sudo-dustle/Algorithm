import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/2573
public class 빙산 {
    public static int N;
    public static int M;
    public static int[] X = {1, -1, 0, 0};//동서남북
    public static int[] Y = {0, 0, -1, 1};
    public static int[][] map;
    public static int[][] copy;
    public static boolean[][] visited;
    public static Queue<Xy> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copy = new int[N][M];

        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                copy[i][j] = tmp;
                visited[i][j] = false;
            }
        }

        int num = 0;
        int days = 0;

        while (true){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        bfs(i, j);
                        num++;//bfs문 돌은 개수(빙산 개수) 체크
                        copyToMap();
                    }
                }
            }


            if(num > 1) break; //bfs문이 한개 초과 돌았으면 빙산이 여러 개이다
            else if(num == 0){//bfs문이 하나도 안돌았다는건 빙산 높이 있는 곳이 없다는 거니깐 0으로 내버리기
                days = 0;
                break;
            }
            makeFalse();
            num = 0;
            days++;
        }

        System.out.println(days);

    }

    private static void makeFalse() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static void copyToMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = copy[i][j];
            }
        }
    }


    private static void bfs(int n, int m) {
        queue.offer(new Xy(n, m));
        visited[n][m] = true;

        while (!queue.isEmpty()) {
            Xy tmp = queue.poll();
            int x, y;

            for (int i = 0; i < 4; i++) {
                x = X[i];
                y = Y[i];

                if (map[(tmp.x + x)][(tmp.y + y)] > 0 && visited[(tmp.x + x)][(tmp.y + y)] == false) {
                    visited[(tmp.x + x)][(tmp.y + y)] = true;
                    queue.offer(new Xy((tmp.x + x), (tmp.y + y)));//빙하 한 덩어리 판별용
                } else if (map[(tmp.x + x)][(tmp.y + y)] == 0 && copy[tmp.x][tmp.y] > 0) {
                    copy[tmp.x][tmp.y]--;//얼음 녹이기
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
