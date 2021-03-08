import java.util.Scanner;

public class lastfactorialdigit {
    static int fact(int n){
        if (n <= 1) {
            return 1;
        } else {
            return n * fact(n-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        for (int i=0; i < loop; i++){
            int curr = sc.nextInt();
            int res = fact(curr);
            System.out.println(res % 10);
        }
        sc.close();
    }
}
