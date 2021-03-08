import java.util.Scanner;

public class apaxiaaans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rawName = sc.next();
        String result = "";

        if (rawName.length() == 1) {
            System.out.println(rawName);
        }

        for (int i = 0; i < rawName.length() - 1; i++) {
            if (! (rawName.charAt(i) == rawName.charAt(i+1))) {
                result += rawName.charAt(i);
            } if (i + 2 == rawName.length()) {
                result += rawName.charAt(i+1);
            }
        }
        sc.close();
        System.out.println(result);
    }
}
