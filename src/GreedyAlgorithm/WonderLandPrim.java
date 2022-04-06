package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class E implements Comparable<E> {
    int vex;
    int edge;
    E(int vex, int edge){
        this.vex = vex;
        this.edge = edge;
    }
    @Override
    public int compareTo(E e){
        return this.edge - e.edge;
    }
}

public class WonderLandPrim {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int v = in.nextInt();
        int e = in.nextInt();
        ArrayList<ArrayList<E>> edges = new ArrayList<>();
        PriorityQueue<E> pq = new PriorityQueue<>();
        int[] ch = new int[v+1];

        for(int i=0; i<=v; i++){
            edges.add(new ArrayList<E>());
        }

        for(int i=0; i<e; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            edges.get(a).add(new E(b, c));
            edges.get(b).add(new E(a, c));
        }

        pq.offer(new E(1, 0));
        //ch[1] = 0;
        int ans = 0;

        while (!pq.isEmpty()){
            E now = pq.poll();
            if(ch[now.vex]!=1){
                ch[now.vex] = 1;
                ans+=now.edge;
                for (E nowEdge : edges.get(now.vex)) {
                    if(ch[nowEdge.vex]!=1) pq.offer(nowEdge);
                }
            }
        }

        System.out.println(ans);
    }
}
