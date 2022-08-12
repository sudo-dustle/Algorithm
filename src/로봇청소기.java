import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기 {
    public static int N;
    public static int M;
    public static int rsl;
    static int[] viewX = {-1, 0, 1, 0};
    static int[] viewY = {0, 1, 0, -1};
    public static int[][] arr;
    public static boolean[][] visited;
    public static void 로봇청소기(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int view = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move(x, y, view);
        System.out.println(rsl);
    }
    public static void move(int x, int y, int view){
        boolean flag = false;

        if(!visited[x][y]) {
            rsl++;
            visited[x][y]=true;
        }

        for (int k = 0; k < 4; k++) {
            int dx = x + viewX[(view+3)%4];
            int dy = y + viewY[(view+3)%4];

            if(arr[dx][dy]==0 && !visited[dx][dy]) {
                move(dx,dy,(view+3)%4);
                flag = true;
                break;
            }
            view = (view+3)%4;
        }

        if(!flag){
            int dx = x + viewX[(view+2)%4];
            int dy = y + viewY[(view+2)%4];

            if(arr[dx][dy]==0) {
                move(dx, dy, view);
            }
        }
    }
}
