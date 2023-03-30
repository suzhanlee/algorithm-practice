package 자바_코딩테스트.시뮬레이션_구현;

import java.util.Arrays;

class 사다리타기 {

    static int[][] ladder;

    public char[] solution(int n, int[][] ladder) {
        char[] answer = new char[n];

        this.ladder = ladder;

        for (int i = 1; i <= n; i++) {

            int i1 = 'A' + i - 1;
            char c = (char) i1;
            int location = move(i);
            answer[location - 1] = c;
        }

        return answer;
    }

    public static int move(int num) {

        for (int i = 0; i < ladder.length; i++) {

            for (int j = 0; j < ladder[i].length; j++) {
                int x = ladder[i][j];
                if(num == x) {
                    num++;
                    break;
                }

                if(num == x + 1) {
                    num--;
                    break;

                }
            }

        }

        return num;
    }

    public static void main(String[] args) {
        사다리타기 T = new 사다리타기();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(
            Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(
            Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12,
            new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10},
                {3, 6, 8, 11}})));
    }
}