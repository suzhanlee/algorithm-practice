package 코테대비52문제.dfs;

public class 바둑대회 {

    static int answer;
    static int[] visited;

    public int solution(int[][] cans) {

        answer = Integer.MAX_VALUE;

        int length = cans.length;

        visited = new int[length];

        dfs(0, cans, length, 0);

        return answer;
    }

    public void dfs(int L, int[][] cans, int length, int cnt) {

        if (L == length / 2 && cnt == length / 2) {

            int white = 0;
            int black = 0;

            for (int i = 0; i < visited.length; i++) {

                if (visited[i] == 1) {
                    white += cans[i][0];
                } else {
                    black += cans[i][1];
                }
            }

            answer = Math.min(answer, Math.abs(white - black));

        } else {

            for (int i = 0; i < cans.length; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    dfs(L + 1, cans, length, cnt + 1);
                    visited[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        바둑대회 T = new 바둑대회();
        System.out.println(
            T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(
            new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33}, {25, 32}, {37, 59},
                {33, 47}}));
    }
}
