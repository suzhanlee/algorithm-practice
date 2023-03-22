package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20546 {

    static int bnp; // 남은 자본
    static int timing; //남은 자본
    static int bnpNum; // 주식 갯수
    static int timingNum; // 주식 갯수
    static int price; // 오늘 주가
    static int[] timings; // 주가 배열
    static int totalBnp; // 총 자본(결과)
    static int totalTiming; // 총 자본(결과)

    public static void bnp(int price) {
        if (bnp >= price) {
            while (bnp >= price) {
                bnp -= price;
                bnpNum++;
            }
        }
    }

    public static void timing(int[] timings) {

        int incre = 0;
        int decre = 0;
        for (int i = 1; i < timings.length; i++) {

            if (timings[i] > timings[i - 1]) {
                incre++;
                decre = 0;
            } else if (timings[i] < timings[i - 1]) {
                decre++;
                incre = 0;
            } else {
                incre = 0;
                decre = 0;
            }

            if (incre >= 3) {
                while (timingNum != 0) {
                    if (timingNum > 0) {
                        timingNum--;
                        totalTiming += timings[i];
                    }
                }
            } else if (decre >= 3) {
                if (timing >= timings[i]) {
                    while (timing >= timings[i]) {
                        timing -= timings[i];
                        timingNum++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        bnp = Integer.parseInt(br.readLine());
        timing = bnp;
        timings = new int[14];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 14; i++) {

            price = Integer.parseInt(st.nextToken());
            bnp(price);
            timings[i] = price;
        }

        timing(timings);

        if (timingNum >= 1) {
            totalTiming += timingNum * timings[13];
        }

        if (timing > 0) {
            totalTiming += timing;
        }

        totalBnp = bnpNum * timings[13];

        if (bnp > 0) {
            totalBnp += bnp;
        }

        if (totalBnp > totalTiming) {
            System.out.println("BNP");
        } else if (totalBnp < totalTiming) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }


    }
}
