import java.util.*;
import java.io.*;
//https://www.acmicpc.net/problem/2075
public class N번째큰수PriorityQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        //첫번째 줄 n개의 Queue 생성
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        //Queue n개 유지하며 입력값 넣기
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                Integer tmp = Integer.parseInt(st.nextToken());
                //Queue 마지막 값과 비교하여 더 클 때만 넣기
                if(tmp > queue.peek()){
                    queue.poll();
                    queue.offer(tmp);
                }
            }
        }
        System.out.println(queue.poll());
    }
}
