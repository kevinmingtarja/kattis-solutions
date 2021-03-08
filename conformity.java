import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class conformity {
    // Kevin Nathanael Mingtarja
    // A0219748N
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        HashMap<HashSet<Integer>, Integer> combinations = new HashMap<HashSet<Integer>, Integer>();
        int n = 0;
        try {
            n = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println("Error");
        }
        int maxCounter = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> currCombination = new HashSet<Integer>();
            String[] currLine = new String[5];
            try {
                currLine = br.readLine().split(" ");
            } catch (IOException e) {
                System.out.println("Error");
            }
            currCombination.add(Integer.parseInt(currLine[0]));
            currCombination.add(Integer.parseInt(currLine[1]));
            currCombination.add(Integer.parseInt(currLine[2]));
            currCombination.add(Integer.parseInt(currLine[3]));
            currCombination.add(Integer.parseInt(currLine[4]));

            if (combinations.get(currCombination) == null) {
                combinations.put(currCombination, 1);
            } else {
                int currCount = combinations.get(currCombination);
                combinations.put(currCombination, currCount + 1);
                if (currCount + 1 > maxCounter) {
                    maxCounter = currCount + 1;
                }
            }
        }

        int counter = 0;
        for (int value : combinations.values()) {
            if (value == maxCounter) {
                counter++;
            }
        }
        if (maxCounter == 0) {
            pw.print(n);
        } else {
            pw.print(maxCounter * counter);
        }

        pw.close();
    }
}
