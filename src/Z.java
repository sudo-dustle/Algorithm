import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
    public static int N;
    public static int X;
    public static int Y;
    public static int cnt = 0;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tmpN = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        N = (int) Math.pow(2, tmpN);
        recursive(0, N, 0, N);
        System.out.println(answer - 1);
    }

    private static void recursive(int startX, int endX, int startY, int endY) {
        int tmp = (endX - startX) / 2;

        if (tmp == 0) {
            cnt++;
            if (startX == X && startY == Y) {
                answer = cnt;
            }
            return;
        }

        if(startX <= X && endX >= X && startY <= Y && endY >= Y) {
            recursive(startX, startX + tmp, startY, startY + tmp);//1
            recursive(startX, startX + tmp, startY + tmp, endY);//2
            recursive(startX + tmp, endX, startY, startY + tmp);//3
            recursive(startX + tmp, endX, startY + tmp, endY);//4
        }
        else {
            int asd = endX - startX;
            cnt += asd*asd;
        }
    }
}
