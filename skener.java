import java.util.Scanner;

public class skener {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int zr = sc.nextInt();
        int zc = sc.nextInt();

        for (int i = 0; i < r; i++) {
            String row = sc.next();
            String result = "";
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < zc; k++) {
                    result += row.charAt(j);
                }
            }

            for (int j = 0; j < zr; j++) {
                System.out.println(result);
            }
        }
    }
}
