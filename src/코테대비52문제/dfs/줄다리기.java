package 코테대비52문제.dfs;
public class 줄다리기 {
    static int answer;
    static int[] pm;
    static int[] visited;
    static int[][] graph;
    public int solution(int[][] fight) {

        answer = 0;

        graph = new int[8][8];

        pm = new int[8];

        visited = new int[8];

        for (int[] ints : fight) {
            int x = ints[0];
            int y = ints[1];

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(0);

        return answer;
    }

    public void dfs(int L) {

        if (L == 7) {
            answer++;

        } else {

            for (int i = 1; i <= 7; i++) {

                if (L >= 1) {
                    if (graph[pm[L]][i] == 1) {
                        continue;
                    }
                }

                if (visited[i] == 0) {
                    visited[i] = 1;
                    pm[L + 1] = i;
                    dfs(L + 1);
                    visited[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        줄다리기 T = new 줄다리기();

        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));

    }
}

