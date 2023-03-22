package 프로그래머스.스킬체크;

public class 문제1 {

    public static int solution(int n, int[] cores) {

        int N = n - cores.length;

        int answer = 0;
//        int[] arr = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = 1;
//        }

        int num = cores.length;
        int[] times = new int[cores.length];

        for (int i = 0; i < cores.length; i++) {
            if(num > 0) {
                times[i] = cores[i];
                num--;
            }else {
                break;
            }
        }

//        int idx = 0;

        while (true) {

            for (int i = 0; i < times.length; i++) {

                times[i] = times[i] - 1;

                if (times[i] == 0) {
                    N--;
                    if (N == 0) {
                        answer = i + 1;
                        return answer;
                    }
                }

                if (times[i] == 0) {
                    times[i] = cores[i];
                }

            }


//            idx++;
        }

    }

//    private boolean isWork() {
//
//    }

    public static void main(String[] args) {

        int[] ints = {1, 2, 3};
        int solution = solution(6, ints);
        System.out.println(solution);

    }

}
