package sw역량테스트문제집.여러유형연습.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 여행경로 {

    List<String> pathList = new ArrayList<>();
    int[] visited;

    public String[] solution(String[][] tickets) {
        visited = new int[tickets.length];
        dfs(tickets, "ICN", 0, "ICN");
        Collections.sort(pathList);

        return pathList.get(0).split(" ");
    }

    private void dfs(String[][] tickets, String now, int L, String next) {
        if (L == tickets.length) {
            pathList.add(next);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (visited[i] == 0 && now.equals(tickets[i][0])) {
                visited[i] = 1;
                dfs(tickets, tickets[i][1], L + 1, next + " " + tickets[i][1]);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        여행경로 main = new 여행경로();
        String[] solution = main.solution(
            new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"},
                {"ATL", "SFO"}});
        System.out.println(Arrays.toString(solution));
    }

}
