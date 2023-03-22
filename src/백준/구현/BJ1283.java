package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ1283 {

    static int N;
    static ArrayList<String> stringArrayList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            String s = br.readLine();
            String[] strings = s.split(" ");
            boolean flag = false;

            for (int j = 0; j < strings.length; j++) {

                String str = String.valueOf(strings[j].charAt(0)).toLowerCase();
                if (!stringArrayList.contains(str)) {
                    flag = true;
                    stringArrayList.add(str);

                    for (int k = 0; k < j; k++) {
                        sb.append(strings[k]).append(" ");
                    }
                    sb.append("[").append(strings[j].substring(0, 1)).append("]")
                        .append(strings[j].substring(1)).append(" ");
                    for (int k = j + 1; k < strings.length; k++) {
                        sb.append(strings[k]).append(" ");
                    }
                    sb.append('\n');
                    break;
                }
            }

            if (flag) {
                continue;
            }

            boolean flag2 = false;

            for (int j = 0; j < strings.length; j++) {
                for (int k = 1; k < strings[j].length(); k++) {

                    String str = String.valueOf(strings[j].charAt(k)).toLowerCase();
                    if (!stringArrayList.contains(str)) {
                        flag2 = true;

                        stringArrayList.add(str);

                        for (int l = 0; l < j; l++) {
                            sb.append(strings[l]).append(" ");
                        }

                        sb.append(strings[j].substring(0, k)).append("[")
                            .append(strings[j].substring(k, k + 1)).append("]")
                            .append(strings[j].substring(k + 1))
                            .append(" ");

                        for (int l = j + 1; l < strings.length; l++) {
                            sb.append(strings[l]).append(" ");
                        }
                        sb.append('\n');

                        break;

                    }
                }

                if (flag2) {
                    break;
                }


            }

            if (!flag2) {
                sb.append(s).append('\n');
            }


        }

        System.out.println(sb);


    }

}
