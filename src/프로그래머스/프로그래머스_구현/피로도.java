package 프로그래머스.프로그래머스_구현;

public class 피로도 {

    static int answer = -1;
    static int[] visited;
    // int[][] dungeons
    // x: 최소 필요 피로도
    // y: 소모 피로도
    // K: 유저의 현재 피로도
    static int K;
    static int[][] dungeonList;


    public static int solution(int k, int[][] dungeons) {

        K = k;
        dungeonList = dungeons;
        visited = new int[dungeonList.length];
        dfs(0, K);

        return answer;

    }

    public static void dfs(int L, int sum) {
        for (int i = 0; i < dungeonList.length; i++) {
            if (visited[i] == 0 && dungeonList[i][0] <= sum) {
                visited[i] = 1;
                dfs(L + 1, sum - dungeonList[i][1]);
                visited[i] = 0;
            }
        }

        answer = Math.max(answer, L);
    }

    public static void main(String[] args) {

    }

}
