package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ16937 {

    static int H, W, N;
    static ArrayList<Sticker> stickers = new ArrayList<>();
    static int answer;

    static class Sticker {

        int R;
        int C;

        public Sticker(int r, int c) {
            R = r;
            C = c;
        }
    }

    public static void solution() {

        int N = H;
        int M = W;
        int max = 0;

        for (int i = 0; i < stickers.size(); i++) {
            int tmp1 = stickers.get(i).R * stickers.get(i).C;
            if (tmp1 == W * H) {
                max = tmp1;
                break;
            }
            for (int j = i + 1; j < stickers.size(); j++) {

                int tmp2 = stickers.get(j).R * stickers.get(j).C;

                if (tmp1 + tmp2 <= W * H) {

                    if (stickers.get(i).R + stickers.get(j).R <= W
                        && stickers.get(i).C + stickers.get(j).C <= H) {
                        max = Math.max(tmp1 + tmp2, max);
                    } else if (stickers.get(i).R + stickers.get(j).R <= H
                        && stickers.get(i).C + stickers.get(j).C <= W) {
                        max = Math.max(tmp1 + tmp2, max);
                    }

                }
            }
        }

        answer = max;


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st1.nextToken());
            int C = Integer.parseInt(st1.nextToken());

            if (R <= H && C <= W) {
                stickers.add(new Sticker(R, C));
                stickers.add(new Sticker(C, R));
            } else if (R <= W && C <= H) {
                stickers.add(new Sticker(R, C));
                stickers.add(new Sticker(C, R));
            }
        }

        solution();

        System.out.println(answer);


    }

}
