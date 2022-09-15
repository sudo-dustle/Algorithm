import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

//문제 https://www.acmicpc.net/problem/1181
//        알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
//
//        길이가 짧은 것부터
//        길이가 같으면 사전 순으로
//        입력
//        첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.
//
//        출력
//        조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
public class 단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> set = new HashSet<>();

        int n = Integer.parseInt(reader.readLine());
        //중복 값 제거 위해 set 사용
        for(int i = 0; i < n; i++){
            set.add(reader.readLine());
        }

        String[] array = set.stream().toArray(String[]::new);

        //단어 순서 그대로 정렬하면 꼬임 단어 길이 조건 반영
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() > s2.length())
                    return 1;
                else if (s1.length() < s2.length())
                    return -1;
                else
                    return s1.compareTo(s2);
            }
        });

        for (String i:array) {
            writer.write(i + "\n");
        }
        writer.flush();
    }
}
