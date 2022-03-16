import java.util.*;

public class FindingCow {
    int[] dis = {1, -1, 5};
    int L=0;
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int s, int e) {
        int[] ch = new int[10001];
        Q.offer(s);
        ch[s] = 1;
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                int x = Q.poll();
                for(int j=0; j<3; j++){
                    int nx = x + dis[j];
                    if(nx == e){
                        return L+1;
                    }
                    if(nx>=1 && nx<=10000 && ch[nx]==0){
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FindingCow f = new FindingCow();
        int s = in.nextInt();
        int e = in.nextInt();
        System.out.println(f.BFS(s, e));
        return;
    }
}
