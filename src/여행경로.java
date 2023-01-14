import java.util.*;

public class 여행경로 {
    public static final String FIRST_TARGET = "ICN";
    public static Map<String, ArrayList<Struct>> onewayTickets = new HashMap<>();
    public static Stack<String> answer = new Stack<>();
    public static int ticketSize;
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}, {"ICN", "AAA"}, {"SFO", "ICN"}};//

        Stack<String> solution = solution(tickets);
        System.out.println(solution);
    }

    public static Stack<String> solution(String[][] tickets) {
        ticketSize = tickets.length + 1;
        saveTickets(tickets);
        System.out.println(onewayTickets);

        answer.add(FIRST_TARGET);
        makeAnswer(FIRST_TARGET);

        return answer;
    }

    private static void makeAnswer(String target) {

        if (!onewayTickets.containsKey(target)) {
            return; // 여기서 걍 끝남 -> 정답 갯수 확인해서 답을 돌려보내야 댐
        }

        ArrayList<Struct> tickets = onewayTickets.get(target);

        for (int i = 0; i < tickets.size(); i++) {
            Struct struct = tickets.get(i);

            if (!struct.isUsed()) {
                answer.add(struct.getCity());
                struct.changeUsed();
                makeAnswer(struct.getCity());
                struct.changeUsed();
                //break 줄줄 나와서 달음
                //정답이 나왔는데 계속 함 -> 해결
                if(answer.size() == ticketSize) {
                    return;
                }
                //answer에 계속 집어넣어서 그렇게 댐
                //잘못되면 삭제해야대나
                answer.pop();
            }
        }
    }

    private static void saveTickets(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            ArrayList<Struct> ticketsOrDefault = onewayTickets.getOrDefault(tickets[i][0], new ArrayList<>());

            Struct struct = new Struct(tickets[i][1]);
            ticketsOrDefault.add(struct);

            onewayTickets.put(tickets[i][0], ticketsOrDefault);
        }

        for(String key : onewayTickets.keySet()) {
            ArrayList<Struct> structs = onewayTickets.get(key);
            structs.sort(Comparator.comparing(Struct::getCity));
        }
    }
}

class Struct {
    public String city;
    public boolean used;

    public Struct(String city) {
        this.city = city;
        this.used = false;
    }

    public String getCity() {
        return city;
    }

    public void changeUsed() {
        used = !used;
    }

    public boolean isUsed() {
        return used;
    }

    @Override
    public String toString() {
        return "Struct{" +
                "city='" + city + '\'' +
                ", used=" + used +
                '}';
    }
}
