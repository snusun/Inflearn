package DP;

import java.util.Scanner;

public class LIS {
    static int[] arr;
    static int[] dy;

    static int solution(int n, int[] arr){
        int ans=0;
        dy[0]=1;
        for(int i=1; i<n; i++){
            int max=0;
            for(int j=i-1; j>=0; j--){
                if(arr[j]<arr[i] && dy[j]>max) max=dy[j];
            }
            dy[i]=max+1;
            ans=Math.max(ans, dy[i]);
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        arr = new int[n];
        dy = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        System.out.println(solution(n, arr));
        return ;
    }
}