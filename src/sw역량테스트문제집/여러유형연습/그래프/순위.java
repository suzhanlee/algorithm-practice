package sw역량테스트문제집.여러유형연습.그래프;

public class 순위 {

    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n + 1][n + 1];

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            graph[winner][loser] = 1;
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int z = 0; z <= n; z++) {
                    if (graph[j][i] == 1 && graph[i][z] == 1) {
                        graph[j][z] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int game = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 1 || graph[j][i] == 1) {
                    game++;
                }
            }
            if (game == n - 1) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        순위 main = new 순위();
        int solution = main.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
        System.out.println(solution);

    }

}
