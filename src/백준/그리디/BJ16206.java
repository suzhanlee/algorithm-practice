package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ16206 {

    static int N, M;
    static long answer;
    static int[] arr;
    static ArrayList<Integer> tens = new ArrayList<>();

    public static void solution() {

        for (int i = 0; i < tens.size(); i++) {

            int cnt = 0;
            Integer num = tens.get(i);

            while (M >= 1) {

                if (num > 10) {
                    num -= 10;
                    M--;
                    cnt++;
                    if (M == 0 && num == 10) {
                        cnt++;
                        answer += cnt;
                        break;
                    } else if (M == 0) {
                        answer += cnt;
                        break;

                    }
                } else if (num == 10) {
                    cnt++;
                    answer += cnt;
                    break;
                }
            }


        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) {
                int cnt = 0;
                while (M >= 1) {

                    if (arr[i] > 10) {
                        arr[i] -= 10;
                        M--;
                        cnt++;
                        if (M == 0) {
                            answer += cnt;
                            break;
                        }
                    }

                    if (arr[i] < 10) {
                        answer += cnt;
                        break;
                    }

                }
            }

        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st1.nextToken());
            if (x % 10 != 0) {
                arr[i] = x;
            } else {
                if (x == 10) {
                    answer++;
                } else {
                    tens.add(x);
                }
            }

        }

        Arrays.sort(arr);
        Collections.sort(tens);

        solution();

        System.out.println(answer);


    }

}
