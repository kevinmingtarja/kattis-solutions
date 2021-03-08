import java.util.LinkedList;
import java.util.Scanner;

class Hand {
    int state;
    int player;

    Hand(int state, int player) {
        this.state = state;
        this.player = player;
    }
}

public class coconut {
    // Kevin Nathanael Mingtarja
    // A0219748N
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int n = sc.nextInt();

        LinkedList<Hand> list = new LinkedList<Hand>();

        for (int i = 1; i <= n; i++) {
            list.add(new Hand(1, i));
        }


        while (true) {
            for (int j = 0; j < s - 1; j++) {
                Hand front = list.pollFirst();
                list.addLast(front);
            }

            Hand touchedLast = list.pollFirst();

            if (touchedLast.state == 1) {
                list.addFirst(new Hand(2, touchedLast.player));
                list.addFirst(new Hand(2, touchedLast.player));
            } else if (touchedLast.state == 2) {
                list.add(new Hand(3, touchedLast.player));
            }

            if (list.size() == 1) {
                break;
            }
        }

        System.out.println(list.getFirst().player);
    }
}
