import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 레이저통신 {
    public static int N;
    public static int M;
    public static int[] positionI = new int[2];
    public static int[] positionJ = new int[2];

    public static String[][] map;
    public static boolean[][][] visited;
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};
    public static Queue<Struct> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        visited = new boolean[N][M][4];

        int count = 0;
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                String s = split[j];

                if (s.equals("C")) {
                    positionI[count] = i;
                    positionJ[count] = j;
                    count += 1;
                }

                map[i][j] = s;
            }
        }

        for (int i = 0; i < 4; i++) {
            shoot(positionI[0], positionJ[0], 0, i);
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            Struct struct = queue.poll();

            if (struct.i == positionI[1] && struct.j == positionJ[1]) {
                return struct.count;
            }

            for (int i = 0; i < 4; i++) {
                shoot(struct.i, struct.j, struct.count + 1, i);
            }
        }

        return -1;
    }

    private static void shoot(int i, int j, int count, int shoot) {
        int tmpI = i;
        int tmpJ = j;

        int shootI = di[shoot];
        int shootJ = dj[shoot];

        while (tmpI >= 0 && tmpI < N && tmpJ >= 0 && tmpJ < M) {
            if(map[tmpI][tmpJ].equals("*")) {
                return;
            }

            if ((map[tmpI][tmpJ].equals(".") || map[tmpI][tmpJ].equals("C")) && !visited[tmpI][tmpJ][shoot]) {
                visited[tmpI][tmpJ][shoot] = true;
                queue.offer(new Struct(tmpI, tmpJ, count, shoot));
            }

            tmpI = tmpI + shootI;
            tmpJ = tmpJ + shootJ;
        }
    }

    static class Struct {
        int i;
        int j;
        int count;
        int direction;

        public Struct(int i, int j, int count, int direction) {
            this.i = i;
            this.j = j;
            this.count = count;
            this.direction = direction;
        }
    }
}
