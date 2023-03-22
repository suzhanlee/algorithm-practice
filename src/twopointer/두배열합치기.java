package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두배열합치기 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N1 = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int[] arr1 = new int[N1];
        int i = 0;

        while (st1.hasMoreTokens()) {
            arr1[i] = Integer.parseInt(st1.nextToken());
            i++;
        }

        int N2 = Integer.parseInt(br.readLine());

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] arr2 = new int[N2];
        int j = 0;

        while (st2.hasMoreTokens()) {
            arr2[j] = Integer.parseInt(st2.nextToken());
            j++;
        }

        int[] arr3 = new int[N1 + N2];

        int k = 0;
        int t = 0;
        int g = 0;

        while (g != N1 + N2) {
            if (k == N1) {
                arr3[g] = arr2[t];
                t++;

            } else if (t == N2) {
                arr3[g] = arr1[k];
                k++;

            } else if (arr1[k] < arr2[t]) {
                arr3[g] = arr1[k];
                k++;

            } else if (arr1[k] >= arr2[t]) {
                arr3[g] = arr2[t];
                t++;
            }
            g++;
        }

        for (int l = 0; l < arr3.length; l++) {
            System.out.print(arr3[l] + " ");

        }


    }

}
