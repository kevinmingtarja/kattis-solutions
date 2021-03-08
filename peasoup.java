import java.util.Scanner;

public class peasoup {
    public static void main(String[] args) {
        // Name: Kevin Nathanael Mingtarja
        // Matriculation Number: A0219748N
        boolean exist;
        String restaurantName;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            boolean peasoup = false;
            boolean pancakes = false;
            int k = sc.nextInt();
            sc.nextLine();
            restaurantName = sc.nextLine();
            String currMenu;
            for (int j = 0; j < k; j++) {
                currMenu = sc.nextLine();
                if (currMenu.equals("pea soup")) {
                    peasoup = true;
                } if (currMenu.equals("pancakes")) {
                    pancakes = true;
                }
            }
            if (peasoup && pancakes) {
                System.out.println(restaurantName);
                return;
            }
        }
        System.out.println("Anywhere is fine I guess");
    }
}
