package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ5597 {

    static int[] visited;
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        visited = new int[31];

        for (int i = 0; i < 28; i++) {
            int num = Integer.parseInt(br.readLine());
            visited[num] = 1;
        }

        for (int i = 1; i <= visited.length - 1; i++) {
            if (visited[i] == 0) {
                arrayList.add(i);
            }
        }

        Collections.sort(arrayList);

        for (int x : arrayList) {
            System.out.println(x);
        }

    }
}
