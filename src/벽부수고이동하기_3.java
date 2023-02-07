import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기_3 {
    public static int N;
    public static int M;
    public static int K;
    public static Queue<Struct> queue = new ArrayDeque<>();
    public static int[][] map;
    public static boolean[][][][] visited;
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][K + 1][2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] split = s.split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        queue.offer(new Struct(0, 0, 1, 0, 0));
        visited[0][0][0][0] = true;
        System.out.println(bfs());
    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            Struct struct = queue.poll();

            if (struct.i == N - 1 && struct.j == M - 1) {
                return struct.count;
            }

            int day;
            if (struct.day == 0) {
                day = 1;
            } else {
                day = 0;
            }

            for (int i = 0; i < 4; i++) {
                int tmpI = struct.i + di[i];
                int tmpJ = struct.j + dj[i];

                if (tmpI < 0 || tmpI >= N || tmpJ < 0 || tmpJ >= M) continue;
                if (map[tmpI][tmpJ] == 1 && struct.day == 1) continue;
                if (map[tmpI][tmpJ] == 1 && struct.breakWall == K) continue;

                int breakWall = struct.breakWall;

                if (map[tmpI][tmpJ] == 1 && struct.breakWall < K) {
                    breakWall = struct.breakWall + 1;
                }

                if (visited[tmpI][tmpJ][breakWall][day]) continue;
                visited[tmpI][tmpJ][breakWall][day] = true;
                queue.offer(new Struct(tmpI, tmpJ, struct.count + 1, breakWall, day));
            }

            if (visited[struct.i][struct.j][struct.breakWall][day]) continue;
            visited[struct.i][struct.j][struct.breakWall][day] = true;
            queue.offer(new Struct(struct.i, struct.j, struct.count + 1, struct.breakWall, day));
        }

        return -1;
    }

    static class Struct {
        public int i;
        public int j;
        public int count;
        public int breakWall;
        public int day; // 낮이면 0 밤이면 1

        public Struct(int i, int j, int count, int breakWall, int day) {
            this.i = i;
            this.j = j;
            this.count = count;
            this.breakWall = breakWall;
            this.day = day;
        }
    }
}


