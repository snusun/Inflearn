package DP;

import java.util.Scanner;

class Problem{
    int s;
    int t;
    Problem(int s, int t){
        this.s = s;
        this.t = t;
    }
}

public class HighestScore {
    static Problem[] problems;
    static int[] times;

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num = in.nextInt();
        int time = in.nextInt();
        problems = new Problem[num];
        times = new int[time+1];

        for(int i=0; i<num; i++){
            int s = in.nextInt();
            int t = in.nextInt();
            problems[i] = new Problem(s, t);
        }

        System.out.println(solution(num, time));

        return ;
    }

    static int solution(int num, int time){
        for(int i=0; i<num; i++){
            for(int j=time; j>=problems[i].t; j--){
                times[j] = Math.max(times[j], times[j-problems[i].t] + problems[i].s);
            }
        }
        return times[time];
    }
}
