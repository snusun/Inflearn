import java.util.Scanner;

public class StackFrame {
    public void DFS(int n){
        if(n==0) return;
        else {
            DFS(n-1);
            System.out.print(n+" ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StackFrame sf = new StackFrame();
        int n = in.nextInt();
        sf.DFS(n);
        return;
    }
}
