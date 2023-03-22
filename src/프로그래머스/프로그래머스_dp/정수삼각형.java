package 프로그래머스.프로그래머스_dp;

public class 정수삼각형 {

    static int N;
    static int answer = Integer.MIN_VALUE;
    static int[][] visited;

    public static int solution(int[][] triangle) {
        visited = new int[triangle.length][];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = new int[i+1];
        }


        N = triangle.length;

        dfs(0, triangle[0][0], 0, triangle);
        return answer;
    }

    public static void dfs(int L, int sum, int c, int[][] triangle) {

        if (L == N - 1) {
            answer = Math.max(answer, sum);
        } else {

            if(visited[L+1][c] == 0) {
                visited[L+1][c] = 1;
                dfs(L + 1, sum + triangle[L + 1][c], c, triangle);
                visited[L+1][c] = 0;
            }

            if(visited[L+1][c+1] == 0) {
                visited[L+1][c+1] = 1;
                dfs(L + 1, sum + triangle[L + 1][c + 1], c + 1, triangle);
                visited[L+1][c+1] = 0;
            }
        }


    }

    public static void main(String[] args) {

        int[][] triangle = new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        int answer = solution(triangle);
        System.out.println(answer);


    }


}
