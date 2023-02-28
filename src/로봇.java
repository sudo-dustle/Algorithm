import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 로봇 {
    public static int N;
    public static int M;
    public static int[][] map;
    public static boolean[][][] visited;
    public static Robot[][][] trace;
    public static Robot depart;
    public static Robot goal;
    public static int[] di = {0, 0, 1, -1}; // 동서남북 1234
    public static int[] dj = {1, -1, 0, 0};
    public static int[] nextDirection = {0, 2, 1, 3};
    public static int[] directI = {0, 1, 0, -1};
    public static int[] directJ = {1, 0, -1, 0};//동남서북
    public static Queue<Robot> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][4];
        trace = new Robot[N][M][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        depart = new Robot(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);

        st = new StringTokenizer(br.readLine());
        goal = new Robot(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);

        depart.setDirection(nextDirection[depart.direction]);
        goal.setDirection(nextDirection[goal.direction]);

        queue.offer(depart);
        visited[depart.i][depart.j][depart.direction] = true;

        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            Robot robot = queue.poll();

            if (robot.equals(goal)) {
//                Robot prev = robot;
//
//                while(prev.count > 0) {
//                    System.out.println(prev);
//                    prev = trace[prev.i][prev.j][prev.direction];
//                }

                return robot.count;
            }

            int tmpI = robot.i;
            int tmpJ = robot.j;

            int right = (robot.direction + 1) % 4;
            int left = (robot.direction + 3) % 4;

            if (!visited[tmpI][tmpJ][right]) {
                visited[tmpI][tmpJ][right] = true;
                trace[tmpI][tmpJ][right] = new Robot(tmpI, tmpJ, robot.direction, robot.count);
                queue.offer(new Robot(tmpI, tmpJ, right, robot.count + 1));
            }

            if (!visited[tmpI][tmpJ][left]) {
                visited[tmpI][tmpJ][left] = true;
                trace[tmpI][tmpJ][left] = new Robot(tmpI, tmpJ, robot.direction, robot.count);
                queue.offer(new Robot(tmpI, tmpJ, left, robot.count + 1));
            }

            for (int i = 0; i < 3; i++) {
                tmpI += directI[robot.direction];
                tmpJ += directJ[robot.direction];

                if (tmpI < 0 || tmpI >= N || tmpJ < 0 || tmpJ >= M) continue;

                if(map[tmpI][tmpJ] == 1) break;

                if (map[tmpI][tmpJ] == 0 && !visited[tmpI][tmpJ][robot.direction]) {
                    visited[tmpI][tmpJ][robot.direction] = true;
                    trace[tmpI][tmpJ][robot.direction] = new Robot(robot.i, robot.j, robot.direction, robot.count);
                    queue.offer(new Robot(tmpI, tmpJ, robot.direction, robot.count + 1));
                }
            }
        }

        return -1;
    }

    public static class Robot {
        private int i;
        private int j;
        private int direction;
        private int count;

        public void setDirection(int direction) {
            this.direction = direction;
        }

        public Robot(int i, int j, int direction, int count) {
            this.i = i;
            this.j = j;
            this.direction = direction;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Robot robot = (Robot) o;
            return i == robot.i && j == robot.j && direction == robot.direction;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j, direction);
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "i=" + i +
                    ", j=" + j +
                    ", direction=" + direction +
                    ", count=" + count +
                    '}';
        }
    }
}
