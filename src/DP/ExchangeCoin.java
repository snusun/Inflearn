package DP;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class ExchangeCoin {
    static int[] coins;
    static int[] price;
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        coins = new int[n];
        for(int i=0; i<n; i++){
            coins[i] = in.nextInt();
        }
        int p = in.nextInt();
        price = new int[p+1];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[0] = 0;

        for(int i=0; i<n; i++){
            for(int j=coins[i]; j<p+1; j++){
                price[j] = Math.min(price[j-coins[i]] + 1, price[j]);
            }
        }

        System.out.println(price[p]);

        return ;
    }
}