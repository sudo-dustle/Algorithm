import java.io.*;
import java.util.*;

public class 토마토 {
    public static int N;
    public static int M;
    public static int[] X = {1, -1, 0, 0};//동서남북
    public static int[] Y = {0, 0, -1, 1};
    public static int[][] map;
    public static Queue<Xy> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if(tmp == 1) queue.offer(new Xy(i,j));//큐에 익은 토마토 추가
            }
        }

        bfs();

        System.out.println(result());;

    }

    //토마토 날짜 계산 메소드
    private static int result() {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0)
                    return -1;
                max = Math.max(max, map[i][j]);

            }
        }
        return max - 1;
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Xy tmp = queue.poll();
            int x,y;
            for (int i = 0; i < 4; i++) {
                x = X[i];
                y = Y[i];
                //동서남북에서 배열을 벗어나지 않게 하기 위한 조건문
                if ((tmp.x + x) >= 0 && (tmp.x + x) < N && (tmp.y + y) >= 0 && (tmp.y + y) < M) {
                    if (map[(tmp.x + x)][(tmp.y + y)] == 0) {
                        queue.offer(new Xy(tmp.x + x, tmp.y + y));
                        //날짜 추가
                        map[tmp.x + x][tmp.y + y] = map[tmp.x][tmp.y] + 1;
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
