import java.util.Scanner;
import java.util.Arrays;

/*
 *  CCC: 15/15
 *  DMOJ: [unknown]
 *  Problem Type: Data Structures/ Implementation
 */

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputCount = scan.nextInt();
        int[] addresses = new int[inputCount];
        for (int i = 0; i < inputCount; i++) {
            addresses[i] = scan.nextInt();
        }
        int hydrants = scan.nextInt();

        Arrays.sort(addresses);

        Distance c = new Distance();
        Distance start = c;
        int highD = 0;

        Distance eStart = c;

        for (int i = 1; i < addresses.length; i++) {
            c.length = addresses[i] - addresses[i-1];
            c.next = new Distance();

            if(c.length > highD) {
                eStart = c.next;
                highD = c.length;
            }

            c = c.next;
        }

        c.length = 1000000 + addresses[0] - addresses[inputCount-1];
        c.next = start;

        if(c.length > highD)
            eStart = c.next;

        int hLength = -1;
        boolean done = false;

        while (!done) {
            hLength++;
            int ropeUsed;
            c = eStart;
            for (int i = 0; i < hydrants && !done; i++) {
                ropeUsed = c.length;
                c = c.next;
                while (ropeUsed <= 2 * hLength && c != eStart) {
                    ropeUsed+=c.length;
                    c = c.next;
                }
                done = c == eStart;
            }
        }
        System.out.println(hLength);
    }
}

class Distance {
    int length;
    Distance next;

    public Distance (int x, Distance y) {
        length = x;
        next = y;
    }

    public Distance () {
        length = 0;
        next = null;
    }
}
