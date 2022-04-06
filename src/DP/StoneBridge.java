package DP;

import java.util.Scanner;

public class StoneBridge {
    static int[] dy;

    static int solution(int n){
        dy[1] = 1;
        dy[2] = 2;
        for(int i=3; i<=n+1; i++){
            dy[i] = dy[i-1] + dy[i-2];
        }
        return dy[n+1];
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        dy=new int[n+2];
        System.out.println(solution(n));
        return ;
    }
}