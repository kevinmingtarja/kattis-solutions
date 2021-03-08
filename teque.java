import java.io.*;

// Kevin Nathanael Mingtarja
// A0219748N
class DequeArr {
    public int[] arr;
    public int front, back;
    public int capacity;
    public int size;
    public final int INITSIZE = 1;

    public DequeArr() {
        arr = new int[INITSIZE]; // create array of integers
        front = 0; // the queue is empty
        back = 0;
        size = 0;
        capacity = INITSIZE;
    }

    public boolean empty() {
        return (front == back);
    }

    public int size() {
        return size;
    }

    public Integer pollFirst() {
        if (empty()) return null;
        Integer item = arr[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public Integer pollLast() {
        if (empty()) return null;
        int removeIdx = back - 1;
        if (removeIdx < 0) {
            removeIdx += capacity;
        }
        Integer item = arr[removeIdx];
        back = removeIdx;
        size--;
        return item;
    }

    public void offerLast(Integer item) {
        if (((back+1)%capacity) == front) // array is full
            enlargeArr();
        arr[back] = item;
        back = (back + 1) % capacity;
        size++;
    }

    public void offerFirst(Integer item) {
        if (((back+1)%capacity) == front) // array is full
            enlargeArr();
        int insertIdx = front - 1;
        if (insertIdx < 0) {
            insertIdx += capacity;
        }
        arr[insertIdx] = item;
        front = insertIdx;
        size++;
    }

    public int get(int idx) {
        return arr[(front + idx) % capacity];
    }

    public boolean enlargeArr() {
        int newSize = capacity * 2;
        int[] temp = new int[newSize];
        if (temp == null) { // i.e. no memory allocated to array of E objects
            System.out.println("Not enough memory");
            System.exit(1);
        }
        for (int j=0; j < capacity; j++) {
            // copy the front (1st) element, 2nd element, ...,  in the
            // original array to the 1st (index 0), 2nd (index 1), ...,
            // position in the enlarged array
            temp[j] = arr[(front + j) % capacity];
        }
        front = 0;
        back = capacity - 1;
        arr = temp;
        capacity = newSize;
        return true;
    }
}


class TequeADT {
    public DequeArr left;
    public DequeArr right;

    public TequeADT() {
        left = new DequeArr();
        right = new DequeArr();
    }

    public void balance(boolean balanceRight) {
        if (balanceRight) {
            left.offerLast(right.pollFirst());
        } else {
            right.offerFirst(left.pollLast());
        }

    }

    public void push_back(int x) {
        right.offerLast(x);
        if (right.size() > left.size()) {
            balance(true);
        }
    }

    public void push_front(int x) {
        left.offerFirst(x);
        if (left.size() > right.size() + 1) {
            balance(false);
        }
    }

    public void push_middle(int x) {
        left.offerLast(x);
        if (left.size() > right.size() + 1) {
            balance(false);
        }
    }

    public int get(int idx) {
        if (idx < left.size()) {
            return left.get(idx);
        } else {
            return right.get(idx - left.size());
        }
    }
}

public class teque {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = 0;
        try {
            n = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println("Error");
        }

        TequeADT list = new TequeADT();

        for (int i = 0; i < n; i++) {
            String line = "";
            try {
                line = br.readLine();
            } catch (IOException e) {
                System.out.println("Error");
            }

            String command = line.split(" ")[0];
            int num = Integer.parseInt(line.split(" ")[1]);

            if (command.equals("push_back")) {
                list.push_back(num);
            } else if (command.equals("push_front")) {
                list.push_front(num);
            } else if (command.equals("push_middle")) {
                list.push_middle(num);
            } else {
                int val = list.get(num);
                pw.println(val);
            }
        }
        pw.close();
    }
}