import java.util.*;

public class autori {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String name = sc.next();
        String[] splitted = name.split("-");

        for (int i = 0; i < splitted.length; i++) {
            System.out.print(splitted[i].charAt(0));
        }
        sc.close();
    }
}
