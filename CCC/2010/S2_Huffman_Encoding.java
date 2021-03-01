import java.util.Scanner;

/*
 *  CCC: 15/15
 *  DMOJ: [unknown]
 *  Problem Type: String Manipulation/Algorithms
 */

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputCount = scan.nextInt();
        scan.skip("\\p{javaWhitespace}+");

        String[][] keys = new String[inputCount][2];
        for (int i = 0; i < inputCount; i++) {
            keys[i] = scan.nextLine().split("\\s");
        }
        String code = scan.nextLine();

        //Solving
        boolean done = false;
        int index = 0;
        String out = "";
        while (!done) {
            for (int i = 0; i < 10; i++) {
                String sub = code.substring(index, index+i+1);
                for (int I = 0; I < inputCount; I++) {
                    if (keys[I][1].equals(sub)) {
                        out+=keys[I][0];
                        index+=i+1;
                        if(index>=code.length()) {
                            done = true;
                        }
                        i = 10;
                        break;
                    }
                }
            }
        }
        System.out.println(out);
    }
}