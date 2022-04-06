package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Player implements Comparable<Player>{
    int height;
    int weight;
    Player(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }
    @Override
    public int compareTo(Player p){
        return p.height-this.height;
    }
}

public class Wrestling {
    static int solution(ArrayList<Player> players){
        int cnt = 0;
        Collections.sort(players);
        int max = Integer.MIN_VALUE;

        for(Player p : players){
            if(p.weight>max){
                max = p.weight;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Player> players = new ArrayList<>();

        for(int i=0; i<n; i++){
            int h = in.nextInt();
            int w = in.nextInt();
            players.add(new Player(h, w));
        }

        System.out.println(solution(players));

        return ;
    }
}