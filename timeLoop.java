import java.util.*;

public class timeLoop {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();

        for (int j=0; j<i; j++){
            System.out.println((j+1) + " Abracadabra");
        }
        sc.close();
    }
}
