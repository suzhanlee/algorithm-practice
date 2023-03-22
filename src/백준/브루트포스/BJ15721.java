package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ15721 { // 4% 에서 실패 ....

    static int A, T, want;
    static int answer;

    public static void bbunSolution() {

        int circle = 4;
        int idx = 1;
        int bbun = 0; //뻔 갯수
        boolean flag = false; // 뻔 갯수가 T만큼 찼는지 여부

        while (true) {
            circle += 2 * (1 + idx); //회차 당 도는 횟수
            for (int i = 1; i <= circle; i++) {
                answer++;
                if (i == 1) {
                    bbun++;

                } else if (i == 3) {
                    bbun++;

                } else if (i > 4 && i <= 4 + (1 + idx)) {
                    bbun++;
                }

                if (bbun == T) { //뻔이 T 개 나오면 리턴
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            idx++;
        }

    }


    public static void degiSolution() {
        int circle = 4;
        int idx = 1;
        int degi = 0; // 데기 갯수
        boolean flag = false; // 데기 갯수가 T만큼 찼는지 여부

        while (true) {
            circle += 2 * (1 + idx);
            for (int i = 1; i <= circle; i++) {
                answer++;
                if (i == 2) {
                    degi++;

                } else if (i == 4) {
                    degi++;
                } else if (i > 4 + 1 + idx) {
                    degi++;
                }

                if (degi == T) { //데기가 T 개 나오면 리턴
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            idx++;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());

        want = Integer.parseInt(br.readLine());

        if (want == 0) {
            bbunSolution();
        } else {
            degiSolution();
        }

        System.out.println((answer - 1) % A);

    }
}
