package 자바_코딩테스트.깊이우선탐색;

import java.util.ArrayList;

class 바둑대회 {

    int n, answer;
    int[] visited;

    public void DFS(int L, int s, int[][] cans) {

        if (L == n / 2) {

            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                if (visited[i] == 1) {

                    A.add(i);

                } else {

                    B.add(i);
                }
            }
            int Asum = 0, Bsum = 0;

            for (int i = 0; i < L; i++) {

                Asum += cans[A.get(i)][0];
                Bsum += cans[B.get(i)][1];
            }

            answer = Math.min(answer, Math.abs(Asum - Bsum));

        } else {

            for (int i = s; i < n; i++) {
                visited[i] = 1;
                DFS(L + 1, i + 1, cans);
                visited[i] = 0;
            }

        }
    }

    public int solution(int[][] cans) {

        answer = 1000000000;
        n = cans.length;
        visited = new int[n];

        DFS(0, 0, cans);

        return answer;

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

