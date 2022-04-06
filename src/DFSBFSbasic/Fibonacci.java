package DFSBFSbasic;

import java.util.Scanner;

public class Fibonacci {
    public static void solution(int n){
        int[] fibo = new int[n];
        fibo[0] = 1;
        fibo[1] = 1;
        for(int i=2; i<n; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        for(int i: fibo){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
    }
}
