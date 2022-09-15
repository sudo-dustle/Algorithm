import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1620
public class 나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        HashMap<String, Integer> string = new HashMap<>();
        HashMap<Integer, String> integer = new HashMap<>();


        //첫 줄 두 숫자 받기
        int[] num = new int[2];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 2; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        //for문 돌면서 순서 값, 단어 HashMap에 저장
        for (int i = 1; i <= num[0]; i++) {
            String tmp = br.readLine();
            string.put(tmp, i);
            integer.put(i, tmp);
        }

        for (int i = 0; i < num[1]; i++) {
            String tmp = br.readLine();

            if (string.containsKey(tmp)) //문자열 키
                bw.write(string.get(tmp) + "\n");
            else// 숫자 값
                bw.write(integer.get(Integer.parseInt(tmp)) + "\n");

        }
        bw.flush();
    }
}