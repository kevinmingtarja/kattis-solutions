import java.util.*;

public class speedlimit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int loop = sc.nextInt();
            if (loop == -1) break;
            int lastTime = 0, dist = 0;
            for (int i = 0; i < loop; i++){
                int speed = sc.nextInt();
                int currTime = sc.nextInt();
                dist += speed * (currTime - lastTime);
                lastTime = currTime;
            }
            System.out.println(dist + " miles");
        }
        sc.close();
    }
}
