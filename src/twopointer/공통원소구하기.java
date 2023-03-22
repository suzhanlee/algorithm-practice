package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 공통원소구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N1 = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int[] arr1 = new int[N1];
        int i1 = 0;
        while (st1.hasMoreTokens()) {
            arr1[i1] = Integer.parseInt(st1.nextToken());
            i1++;
        }

        int N2 = Integer.parseInt(br.readLine());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr2 = new int[N2];
        int i2 = 0;
        while (st2.hasMoreTokens()) {
            arr2[i2] = Integer.parseInt(st2.nextToken());
            i2++;
        }

        List<Integer> array = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0;
        int j = 0;
        while (!(i == N1 || j == N2)) {

            if (arr1[i] == arr2[j]) {
                array.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                i++;
            }
        }

        for (Integer integer : array) {
            System.out.print(integer + " ");
        }

    }
}
