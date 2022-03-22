import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Road implements Comparable<Road>{
    int inVex;
    int outVex;
    int edge;
    Road(int inVex, int outVex, int edge) {
        this.inVex = inVex;
        this.outVex = outVex;
        this.edge = edge;
    }
    @Override
    public int compareTo(Road r){
        return this.edge - r.edge;
    }
}

public class WonderLand {
    static int[] unf;

    static int Find(int a){
        if(unf[a]==a) return a;
        else return unf[a] = Find(unf[a]);
    }

    static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb){
            unf[fa] = fb;
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int v = in.nextInt();
        int e = in.nextInt();
        ArrayList<Road> roads = new ArrayList<>();
        unf = new int[v+1];

        for(int i=0; i<v; i++){
            unf[i] = i;
        }

        for(int i=0; i<e; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            roads.add(new Road(a, b, c));
        }

        Collections.sort(roads);
        int sum = 0;

        /*for(int i=0; i<e; i++){
            System.out.println(roads.get(i).edge);
        }*/

        for(int i=0; i<e; i++){
            Road r = roads.get(i);
            int fa = Find(r.inVex);
            int fb = Find(r.outVex);
            Union(r.inVex, r.outVex);
            if(fa != fb) {
                //System.out.println(r.edge);
                sum += r.edge;
            }
        }

        System.out.println(sum);
        return ;
    }

}
