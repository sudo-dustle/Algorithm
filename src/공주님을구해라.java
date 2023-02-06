import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공주님을구해라 {
    public static int N;
    public static int M;
    public static int T;
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
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue.offer(new Struct(0, 0, 0, 0));
        visited[0][0][0] = true;
        System.out.println(bfs());
    }

    public static String bfs() {
        while (!queue.isEmpty()) {
            Struct struct = queue.poll();

            if (struct.count > T) {
                return "Fail";
            }

            if (struct.i == N - 1 && struct.j == M - 1) {
                return String.valueOf(struct.count);
            }

            for (int n = 0; n < 4; n++) {
                int tmpI = struct.i + di[n];
                int tmpJ = struct.j + dj[n];

                if (tmpI < 0 || tmpI >= N || tmpJ < 0 || tmpJ >= M) continue;
                if (map[tmpI][tmpJ] == 1 && struct.hasSword == 0) continue;

                int hasSword = struct.hasSword;
                if (map[tmpI][tmpJ] == 2) {
                    hasSword = 1;
                }
/*
                3,5에서 검은 있는데 visited가 이미 true 라서 걍 넘어감 그리고 딴 때 보면 검이 없음ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
                1. 검이 없음
                2. 검이 있는데 그냥 비지트 통과해버림

                예상 : 뭔가 비지트가 잘못됨 -> 다시 돌아왔는데 이미 true 해버림
 */
                if (visited[tmpI][tmpJ][hasSword]) continue;
                visited[tmpI][tmpJ][hasSword] = true;
                queue.offer(new Struct(tmpI, tmpJ, struct.count + 1, hasSword));
            }
        }

        return "Fail";
    }

    static class Struct {
        int i;
        int j;
        int count;
        int hasSword;

        public Struct(int i, int j, int count, int hasSword) {
            this.i = i;
            this.j = j;
            this.count = count;
            this.hasSword = hasSword;
        }
    }
}
