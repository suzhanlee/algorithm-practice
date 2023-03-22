package 프로그래머스.pccp모의고사;

public class 체육대회 {

    static int[][] ability;
    static int cnt;
    static int[] arr;
    static int max;
    static int answer;

    public static int solution(int[][] ability) {
        cnt = ability[0].length;
        체육대회.ability = ability;

        arr = new int[cnt];

        combi(0, 0);

        return answer;
    }

    public static void combi(int L, int startPoint) {

        if (L == cnt) {
            for (int i = 0; i < cnt; i++) {

                System.out.print(arr[i] + " ");
            }

            for (int i = 0; i < arr.length; i++) {

                int tmpMax = 0;

                int pick = arr[i];

                for (int j = 0; j < ability.length; j++) {

                    int tmp = ability[j][pick];
                    tmpMax = Math.max(tmpMax, pick);


                }
                max += tmpMax;

            }

            answer = Math.min(max, answer);
            System.out.println();

        } else {
            for (int i = startPoint; i < cnt; i++) {  // 뻣는 가지 개수

                arr[L] = i;
                combi(L + 1, i + 1);

            }
        }
    }

    public static void main(String[] args) {

        int[][] ints = {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}};

        int solution = solution(ints);
        System.out.println(solution);

    }

}
