import java.io.IOException;
import java.util.*;

class 오픈채팅방 {
    //2시 50분 ~ 3시 18분
    public static void main(String[] args) throws IOException {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        ArrayList<String> solution = solution(record);
        for(String i : solution) {
            System.out.println(i);
        }
    }
    public static ArrayList<String> solution(String[] records) throws IOException {
        ArrayList<String> answer = new ArrayList<>();
        Queue<accessRecord> queue = new LinkedList<>();
        HashMap<String, String> user = new HashMap<>(); // (uid, 이름)

        for(String record : records) {
            String[] split = record.split(" ");
            queue.offer(new accessRecord(split[1], split[0]));

            if(!split[0].equals("Leave")) {
                user.put(split[1], split[2]);
            }
        }

        while (!queue.isEmpty()) {
            accessRecord poll = queue.poll();
            if(poll.access.equals("Enter")) {
                answer.add(user.get(poll.uid) + "님이 들어왔습니다." );
            }
            else if(poll.access.equals("Leave")){
                answer.add(user.get(poll.uid) + "님이 나갔습니다." );
            }
        }

        return answer;
    }
    public static class accessRecord {
        private String uid;
        private String access;

        public accessRecord(String uid, String access) {
            this.uid = uid;
            this.access = access;
        }
    }
}
