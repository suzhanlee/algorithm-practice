package sortingandsearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 좌표정렬 {

    static ArrayList<Point> arrayList = new ArrayList<>();

    static class Point implements Comparable<Point> {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {

            if (this.x == p.x) {
                return this.y - p.y;
            } else {
                return this.x - p.x;
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arrayList.add(new Point(x, y));
        }

        Collections.sort(arrayList, Point::compareTo);

        for (Point p : arrayList) {
            System.out.println(p.x + " " + p.y);
        }
    }

}
