import java.util.*;

/*
 *  CCC: 15/15
 *  DMOJ: 100/100 (1.849s, 73.23 MB)
 *  Problem Type: String Algorithms
 */

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.skip("\\p{javaWhitespace}+");
        int tCount = 0, sCount = 0;
        String str = "";
        for (int i = 0; i < N; i++)
            str += scan.nextLine().toUpperCase();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'T')
                tCount++;
            if (str.charAt(i) == 'S')
                sCount++;
        }
        System.out.println(tCount > sCount ? "English" : "French");
    }
}