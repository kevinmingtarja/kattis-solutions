import java.util.Scanner;

public class exactlyelectrical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int y1 = sc.nextInt();
        int x1 = sc.nextInt();
        int y2 = sc.nextInt();
        int x2 = sc.nextInt();
        int charge = sc.nextInt();

        int stepsNeeded = Math.abs(y2 - y1) + Math.abs(x2 - x1);

        if (charge < stepsNeeded) {
            System.out.println('N');
        } else if ((charge - stepsNeeded) % 2 == 0) {
            System.out.println('Y');
        } else {
            System.out.println('N');
        }
    }
}
