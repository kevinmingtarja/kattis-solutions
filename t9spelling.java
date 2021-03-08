import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class t9spelling {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String[] table = new String[]{"2", "22", "222", "3", "33", "333", "4", "44", "444",
                "5", "55", "555", "6", "66", "666", "7", "77", "777", "7777", "8", "88", "888",
                "9", "99", "999", "9999"};
        int n = 0;

        try {
            n = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println("cant read");
        }

        for (int i = 0; i < n; i++) {
            pw.print(String.format("Case #%d: ", i+1));
            String message = "";

            try {
                message = br.readLine();
            } catch (IOException e) {
                System.out.println("cant read");
            }

            Character check = 'A';

            for (int j = 0; j < message.length(); j++) {
                if (check == message.charAt(j)) {
                    pw.print(" ");
                }
                if (' ' == (message.charAt(j))) {
                    pw.print("0");
                } else {
                    String current = table[message.charAt(j) - 97];
                    if (check != 'A' && check != ' ') {
                        String previous = table[check - 97];

                        if (previous.charAt(0) == current.charAt(0)) {
                            pw.print(" ");
                        }
                    }
                    pw.print(current);
                }
                check = message.charAt(j);
            }
            pw.println();
        }
        pw.close();

    }
}
