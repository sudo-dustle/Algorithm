import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/2206
public class 벽부수고지나가기 {
    public static int N;
    public static int M;
    public static int[][] map;
    public static int[][][] visited;
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
        visited = new int[N + 1][M + 1][2];

        for (int i = 1; i < N + 1; i++) {
            String[] str = br.readLine().split("");
            for (int j = 1; j < M + 1; j++) {
                int tmp = Integer.parseInt(str[j - 1]);
                map[i][j] = tmp;
            }
        }

        bfs(1, 1);
        if(rsl != Integer.MAX_VALUE)System.out.println(rsl);
        else if (N == 1 && M == 1) System.out.println("1");
        else System.out.println("-1");


    }

    public static void bfs(int n, int m) {
        queue.offer(new Xy(n, m, 0));
        visited[n][m][0] = 1;

        while (!queue.isEmpty()) {
            Xy tmp = queue.poll();
            if(tmp.x == N+1 && tmp.y == M+1) return ;

            for (int i = 0; i < 4; i++) {
                int tmpX = X[i] + tmp.x;
                int tmpY = Y[i] + tmp.y;

                if (tmpX >= 1 && tmpX < N + 1 && tmpY >= 1 && tmpY < M + 1){
                    if (map[tmpX][tmpY] == 0) {
                        if (tmp.breakWall == 0 && visited[tmpX][tmpY][0] == 0) {//부순적 없고 map == 0
                            visited[tmpX][tmpY][0] = visited[tmp.x][tmp.y][0] + 1;

                            if (tmpX == N && tmpY == M) {
                                rsl = Integer.min(visited[tmpX][tmpY][0], rsl);
                            }
                            queue.offer(new Xy(tmpX, tmpY, tmp.breakWall));
                        } else if (tmp.breakWall == 1 && map[tmpX][tmpY] == 0 && visited[tmpX][tmpY][1] == 0) {//부순적 있고 map == 0
                            visited[tmpX][tmpY][1] = visited[tmp.x][tmp.y][1] + 1;

                            if (tmpX == N && tmpY == M) {
                                rsl = Integer.min(visited[tmpX][tmpY][1], rsl);
                            }
                            queue.offer(new Xy(tmpX, tmpY, tmp.breakWall));
                        }
                    } else if (map[tmpX][tmpY] == 1) {
                        if (tmp.breakWall == 0 && visited[tmpX][tmpY][0] == 0) {//부순적 없고 map == 1
                            visited[tmpX][tmpY][1] = visited[tmp.x][tmp.y][0] + 1;
                            queue.offer(new Xy(tmpX, tmpY, tmp.breakWall + 1));//부순 경험을 queue에 포함시키기
                        }
                    }

                }
            }
        }
    }

    private static class Xy {
        private int x;
        private int y;
        private int breakWall;

        public Xy(int x, int y, int breakWall) {
            this.x = x;
            this.y = y;
            this.breakWall = breakWall;
        }
    }
}
