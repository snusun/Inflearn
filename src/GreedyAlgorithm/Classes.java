package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Class implements Comparable<Class> {
    int m;
    int d;
    Class(int m, int d){
        this.m = m;
        this.d = d;
    }
    @Override
    public int compareTo(Class c){
        return c.d - this.d;
    }
}

public class Classes {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int answer=0;
        ArrayList<Class> classes = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++) {
            int m = in.nextInt();
            int d = in.nextInt();
            classes.add(new Class(m,d));
        }

        int idx=0;
        Collections.sort(classes);
        int max = classes.get(0).d;
        for(int i=max; i>0; i--){
            for(int j=idx; j<n; j++){
                if(classes.get(j).d<i){
                    idx=j;
                    break;
                }
                pq.offer(classes.get(j).m);
            }

            if(!pq.isEmpty()) answer+=pq.poll();
        }

        System.out.println(answer);
    }
}



