import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기_2 {
    public static int N;
    public static int M;
    public static int K;
    public static int[][] map;
    public static boolean[][][] visited;
    public static Queue<Struct> queue = new LinkedList<>();
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            String[] split = tmp.split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        queue.offer(new Struct(0, 0, 1, 0));
        visited[0][0][0] = true;
        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            Struct struct = queue.poll();

            if (struct.i == N - 1 && struct.j == M - 1) {
                return struct.count;
            }

            for (int n = 0; n < 4; n++) {
                int tmpI = struct.i + di[n];
                int tmpJ = struct.j + dj[n];

                if (tmpI < 0 || tmpI >= N || tmpJ < 0 || tmpJ >= M) continue;
                if (map[tmpI][tmpJ] == 1 && struct.breakCount == K) continue;

                int breakCount = struct.breakCount;
                if (map[tmpI][tmpJ] == 1 && struct.breakCount < K) {
                    breakCount = struct.breakCount + 1;
                }

                if(visited[tmpI][tmpJ][breakCount]) continue;
                visited[tmpI][tmpJ][breakCount] = true;
                queue.offer(new Struct(tmpI, tmpJ, struct.count + 1, breakCount));
            }
        }
        return -1;
    }

    static class Struct {
        int i;
        int j;
        int count;
        int breakCount;

        public Struct(int i, int j, int count, int breakCount) {
            this.i = i;
            this.j = j;
            this.count = count;
            this.breakCount = breakCount;
        }
    }
}
