import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시험감독 {
    public static long rsl = 0;
    public static long[] supervisor = new long[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] testRooms = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i < N; i++){
            testRooms[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<2; i++){
            supervisor[i] = Integer.parseInt(st.nextToken());
        }

        for(long testRoom : testRooms){
            solve(testRoom);
        }
        System.out.println(rsl);
    }

    private static void solve(long testRoom) {
        testRoom -= supervisor[0];
        rsl += 1;

        if(testRoom > 0){
            long tmp = testRoom / supervisor[1];
            rsl += tmp;
            if(testRoom % supervisor[1] != 0) rsl += 1;
        }
    }
}
