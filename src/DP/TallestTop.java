package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Brick implements Comparable<Brick> {
    int area;
    int height;
    int weight;

    Brick(int area, int height, int weight) {
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Brick o) {
        if(o.area==this.area){
            return o.weight - this.weight;
        }
        return o.area - this.area;
    }
}

public class TallestTop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Brick> bricks = new ArrayList<>();
        int[] totalHeight = new int[n];

        for(int i=0; i<n; i++){
            int area = in.nextInt();
            int height = in.nextInt();
            int weight = in.nextInt();
            bricks.add(new Brick(area,height,weight));
        }

        Collections.sort(bricks);

        totalHeight[0] = bricks.get(0).height;
        for(int i=1; i<n; i++){
            int max = 0;
            for(int j = i-1; j>=0; j--){
                if(totalHeight[j] > max && bricks.get(i).weight < bricks.get(j).weight){
                    max = totalHeight[j];
                }
            }
            totalHeight[i] = max + bricks.get(i).height;
        }

        int maxHeight=0;
        for(int i=0; i<n; i++){
            if(totalHeight[i] > maxHeight){
                maxHeight = totalHeight[i];
            }
        }

        System.out.println(maxHeight);

        return;
    }
}
