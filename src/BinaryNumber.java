import java.util.Scanner;

public class BinaryNumber {
    public static void solution(int n) {
        if(n==0) return;
        else {
            solution(n/2);
            System.out.print(n%2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
        return;
    }
}
