package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16953_1 {

    static int A, B;
    static long answer = Long.MAX_VALUE;
    static boolean flag = true;
//    static int[] visited;

    public static void dfs(int L, long num) {

        if(num > B) {
            return;
        }

        if(num == B) {

            answer = Math.min(answer, L);

        } else {

            dfs(L+1, num * 2);
            dfs(L+1,num*10 + 1);

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

//        visited = new int[Integer.MAX_VALUE];


        dfs(0,A);

        if(answer != Long.MAX_VALUE) {
            System.out.println(answer + 1);
        } else {
            System.out.println(-1);
        }




    }

}
