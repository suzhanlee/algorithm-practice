package 자바_코딩테스트.깊이우선탐색;

import java.util.*;
class 가장가까운큰수 {
    int answer, target, m;
    ArrayList<Integer> nums;
    int[] ch;
    boolean flag;
    public void DFS(int L, int number){
        if(flag) return;
        if(L == m){
            if(number > target){
                answer = number;
                flag = true;
            }
        }
        else{
            for(int i = 0; i < m; i++){
                if(ch[i] == 0){
                    ch[i] = 1;
                    DFS(L + 1, number * 10 + nums.get(i));
                    ch[i] = 0;
                }
            }
        }
    }
    public int solution(int n){
        answer = 0;
        flag = false;
        nums = new ArrayList<>();
        target = n;
        int tmp = n;
        while(tmp > 0){
            int t = tmp%10;
            nums.add(t);
            tmp = tmp / 10;
        }
        nums.sort((a, b) -> a - b);
        m = nums.size();
        ch = new int[m];
        DFS(0, 0);
        if(flag == false) return -1;
        return answer;
    }

    public static void main(String[] args){
        가장가까운큰수 T = new 가장가까운큰수();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
