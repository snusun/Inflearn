package GreedyAlgorithm;

import java.util.*;
class Edge implements Comparable<Edge>{
    public int vex;
    public int cost;
    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob){
        return this.cost-ob.cost;
    }
}

public class Dijkstra {
    static int n, m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    public static void solution(int v){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));
        dis[v] = 0;
        while (!pQ.isEmpty()){
            Edge temp = pQ.poll();
            int now = temp.vex;
            int nowCost = temp.cost;
            if(dis[now]<nowCost) continue;
            for(Edge ob: graph.get(now)){
                if(dis[ob.vex]>ob.cost+nowCost){
                    dis[ob.vex] = ob.cost + nowCost;
                    pQ.offer(new Edge(ob.vex, dis[ob.vex]));
                }
            }

        }
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        }
        dis=new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            int c=kb.nextInt();
            graph.get(a).add(new Edge(b, c));
        }
        solution(1);
        for(int i=2; i<=n; i++){
            if(dis[i]!=Integer.MAX_VALUE) System.out.println(i+" : "+dis[i]);
            else System.out.println(i+" : impossible");
        }
    }
}