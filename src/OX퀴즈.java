import java.io.*;
//https://www.acmicpc.net/problem/8958
public class OX퀴즈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String[] str = br.readLine().split("");

            int score = 0;
            int tmp = 0;

            for(String s : str){
                if(s.equals("O")){
                    tmp = tmp + 1;
                    score += tmp;
                }
                else if(s.equals("X")) tmp = 0;
            }

            System.out.println(score);
        }
    }
}
