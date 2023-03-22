package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1043 {

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {

            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st1.nextToken());

            for (int j = 0; j < x; j++) {
                int e = Integer.parseInt(st1.nextToken());

            }


        }



    }

}
