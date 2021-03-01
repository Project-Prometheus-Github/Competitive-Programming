import java.util.*;

/*
 *  CCC: 15/15
 *  DMOJ: 50/50 (0.746s, 58.84 MB)
 *  Problem Type: Implementation
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean done = false;
        while(true) {
            int c = scan.nextInt();
            if (c == 0)
                break;
            int[] v = new int[c-1];
            int last = scan.nextInt();
            if (c == 1) {
                System.out.println(0);
                continue;
            }
            int next;
            for(int i = 0; i < c - 1; i++) {
                next = scan.nextInt();
                v[i] = next-last;
                //System.out.println(v[i]);
                last = next;
            }
            int i;
            for(i = 1; i < c - 1; i++) {
                done = true;
                for(int I = 0; I < i; I++) {
                    for (int y = 0; y < c - 1 - I; y+=i) {
                        //System.out.println(i+" "+I + " " + y +",    " + v[I]+", "+v[y+I]);
                        if (v[I] != v[y+I]) {
                            I = i;
                            done = false;
                            break;
                        }
                    }
                }
                if (done)
                    break;
            }
            System.out.println(i);
        }
    }
}
